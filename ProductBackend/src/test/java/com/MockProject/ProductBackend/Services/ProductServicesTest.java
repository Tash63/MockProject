package com.MockProject.ProductBackend.Services;

import com.MockProject.ProductBackend.Data.Model.Product;
import com.MockProject.ProductBackend.Data.Repositories.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServicesTest {

    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductServices productServices;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getAllProducts() {
        List<Product> Products = new ArrayList<>();
        Products.add(new Product(Long.valueOf(1), "Speedpoint", Double.valueOf(400)));
        Products.add(new Product(Long.valueOf(2), "Speedee", Double.valueOf(200)));
        Products.add(new Product(Long.valueOf(3), "SpeedeeQR", Double.valueOf(100)));
        when(productRepository.findAll()).thenReturn(Products);
        assertIterableEquals(Products, productServices.getAllProducts());
    }
}