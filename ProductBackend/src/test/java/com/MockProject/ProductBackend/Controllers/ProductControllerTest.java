package com.MockProject.ProductBackend.Controllers;

import com.MockProject.ProductBackend.Data.Model.Product;
import com.MockProject.ProductBackend.Services.ProductServices;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = ProductController.class)
class ProductControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductServices productServices;

    @Test
    void getProducts() throws Exception {
        List<Product> Products = new ArrayList<>();
        Products.add(new Product(Long.valueOf(1), "Speedpoint", Double.valueOf(400)));
        Products.add(new Product(Long.valueOf(2), "Speedee", Double.valueOf(200)));
        Products.add(new Product(Long.valueOf(3), "SpeedeeQR", Double.valueOf(100)));
        when(productServices.getAllProducts()).thenReturn(Products);
        MvcResult response = mockMvc.perform(get("/api/product/")).andReturn();
        ObjectMapper objectMapper = new ObjectMapper();
        assertEquals(200, response.getResponse().getStatus());
        assertIterableEquals(Products, objectMapper.readValue(response.getResponse().getContentAsByteArray(), new TypeReference<List<Product>>() {
        }));
    }

}