package com.MockProject.ProductFrontend.Controller;

import com.MockProject.ProductFrontend.Model.Services.ProductServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = ProductController.class)
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductServices productServices;

    @Test
    void apply() throws Exception {
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/apply")).andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }

}