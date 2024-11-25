package com.MockProject.ProductBackend.Controllers;

import com.MockProject.ProductBackend.Data.Model.Product;
import com.MockProject.ProductBackend.Data.Model.ProductUser;
import com.MockProject.ProductBackend.Data.Model.ProductUserCreate;
import com.MockProject.ProductBackend.Services.ProductUserServices;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(controllers = ProductUserController.class)
@ExtendWith(MockitoExtension.class)
class ProductUserControllerTest {
    @MockBean
    ProductUserServices productUserServices;
    @Autowired
    MockMvc mockMvc;

    @Test
    void saveProductToUser() throws Exception {
        ProductUserCreate productUserCreate = new ProductUserCreate(1, Long.valueOf(1));
        Product product = new Product(Long.valueOf(1), "Speedee", Double.valueOf(400));
        ProductUser productUser = new ProductUser(Long.valueOf(1), 1, product);
        ObjectMapper objectMapper = new ObjectMapper();
        Mockito.when(productUserServices.SaveProductToUser(productUserCreate)).thenReturn(productUser);
        MvcResult response = mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsBytes(productUserCreate))).andReturn();
        assertEquals(201, response.getResponse().getStatus());
    }

    @Test
    void getProductsForUsers() throws Exception {
        List<Product> UserSelectedProducts = new ArrayList<>();
        UserSelectedProducts.add(new Product(Long.valueOf(1), "Speedpoint", Double.valueOf(400)));
        UserSelectedProducts.add(new Product(Long.valueOf(2), "Speedee", Double.valueOf(200)));
        UserSelectedProducts.add(new Product(Long.valueOf(1), "Speedpoint", Double.valueOf(400)));
        UserSelectedProducts.add(new Product(Long.valueOf(2), "Speedee", Double.valueOf(200)));
        UserSelectedProducts.add(new Product(Long.valueOf(1), "Speedpoint", Double.valueOf(400)));
        Mockito.when(productUserServices.getProductsByCustomer(Long.valueOf(1))).thenReturn(UserSelectedProducts);
        MvcResult response = mockMvc.perform(get("/api/user/1")).andReturn();
        ObjectMapper objectMapper = new ObjectMapper();
        assertEquals(200, response.getResponse().getStatus());
        assertIterableEquals(UserSelectedProducts, objectMapper.readValue(response.getResponse().getContentAsByteArray(), new TypeReference<List<Product>>() {
        }));
    }
}