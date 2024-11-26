package com.MockProject.ProductFrontend.Controller;

import com.MockProject.ProductFrontend.Model.Product;
import com.MockProject.ProductFrontend.Model.ProductUser;
import com.MockProject.ProductFrontend.Model.Services.ProductUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.thymeleaf.spring6.expression.Mvc;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = UserController.class)
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductUserService productUserService;

    @Test
    void loginPage() throws Exception {
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/")).andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    void menuWithCustomerId() throws Exception {
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/menu?customerId=12")).andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    void menuWithExistingCustomerId() throws Exception {
        Mockito.when(productUserService.getId()).thenReturn(12);
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/menu")).andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    void menuWithoutExistingCustomerId() throws Exception {
        Mockito.when(productUserService.getId()).thenReturn(null);
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/menu")).andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    void viewproductsWithCustomerId() throws Exception {
        Mockito.when(productUserService.getId()).thenReturn(12);
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/viewproducts")).andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    void viewproductsWithoutCustomerId() throws Exception {
        Mockito.when(productUserService.getId()).thenReturn(null);
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/viewproducts")).andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    void saveproduct() throws Exception {
        ProductUser productUser = new ProductUser().id(1l).uid(1).selectedproduct(new Product().id(1L).productName("Speedpoint").monthlyFee(400D));
        Mockito.when(productUserService.SaveProductToUser(1l)).thenReturn(productUser);
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.post("/addproduct?pid=1")).andReturn();
        assertEquals(200, response.getResponse().getStatus());
    }
}