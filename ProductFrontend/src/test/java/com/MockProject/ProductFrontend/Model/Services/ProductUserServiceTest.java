package com.MockProject.ProductFrontend.Model.Services;

import com.MockProject.ProductFrontend.Model.Clients.ProductUserClient;
import com.MockProject.ProductFrontend.Model.Product;
import com.MockProject.ProductFrontend.Model.ProductUser;
import com.MockProject.ProductFrontend.Model.ProductUserCreate;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductUserServiceTest {
    @Mock
    ProductUserClient productUserClient;

    @InjectMocks
    ProductUserService productUserService;

    @Test
    void saveProductToUser() {
        productUserService.setId(1);
        ProductUser productUser = new ProductUser().id(1l).uid(1).selectedproduct(new Product().id(1L).productName("Speedpoint").monthlyFee(400D));
        Mockito.when(productUserClient.saveProductToUser(ArgumentMatchers.any(ProductUserCreate.class))).thenReturn(productUser);
        ProductUser productUserResult = productUserService.SaveProductToUser(1l);
        assertTrue(productUser.equals(productUserResult));
    }

    @Test
    void getProductsByUser() {
        List<Product> UserSelectedProducts = new ArrayList<>();
        UserSelectedProducts.add(new Product().id(1L).productName("Speedpoint").monthlyFee(400D));
        UserSelectedProducts.add(new Product().id(2l).productName("Speedee").monthlyFee(200D));
        UserSelectedProducts.add(new Product().id(3l).productName("SpeedeeQR").monthlyFee(100D));
        UserSelectedProducts.add(new Product().id(2l).productName("Speedee").monthlyFee(200D));
        UserSelectedProducts.add(new Product().id(1L).productName("Speedpoint").monthlyFee(400D));
        productUserService.setId(1);
        Mockito.when(productUserClient.getProductsByUser(1)).thenReturn(UserSelectedProducts);
        List<Product> UserSelectedProductsResult = productUserService.getProductsByUser();
        assertIterableEquals(UserSelectedProducts, UserSelectedProductsResult);
    }
}