package com.MockProject.ProductFrontend.Model.Services;

import com.MockProject.ProductFrontend.Model.Clients.ProductClient;
import com.MockProject.ProductFrontend.Model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServicesTest {

    @Mock
    ProductClient productClient;

    @InjectMocks
    ProductServices productServices;

    @Test
    void getAllProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product().id(1L).productName("Speedpoint").monthlyFee(400D));
        products.add(new Product().id(2l).productName("Speedee").monthlyFee(200D));
        products.add(new Product().id(3l).productName("SpeedeeQR").monthlyFee(100D));
        Mockito.when(productClient.getAllProducts()).thenReturn(products);
        List<Product> productsResult = productServices.getAllProducts();
        assertIterableEquals(productsResult, products);
    }
}