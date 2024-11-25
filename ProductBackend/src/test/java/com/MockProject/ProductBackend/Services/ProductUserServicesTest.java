package com.MockProject.ProductBackend.Services;

import com.MockProject.ProductBackend.Data.Model.Product;
import com.MockProject.ProductBackend.Data.Model.ProductUser;
import com.MockProject.ProductBackend.Data.Model.ProductUserCreate;
import com.MockProject.ProductBackend.Data.Repositories.ProductRepository;
import com.MockProject.ProductBackend.Data.Repositories.ProductUserRepository;
import net.bytebuddy.dynamic.DynamicType;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductUserServicesTest {

    @Mock
    ProductUserRepository productUserRepository;
    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductUserServices productUserServices;

    @Test
    void saveProductToUserWhereProductExists() {
        Product product = new Product(Long.valueOf(1), "Speedpoint", Double.valueOf(400));
        when(productRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(product));
        ProductUser productUser = new ProductUser(Long.valueOf(1), 1, product);
        when(productUserRepository.save
                (any(ProductUser.class))).thenReturn(productUser);
        assertNotNull(productUserServices.SaveProductToUser(new ProductUserCreate(1, Long.valueOf(1))));
    }

    @Test
    void saveProductToUserWhereProductDoesNotExist() {
        assertThrows(ResponseStatusException.class, () -> {
            productUserServices.SaveProductToUser(new ProductUserCreate(1, Long.valueOf(4)));
        });
    }

    @Test
    void getProductsByCustomer() {
        List<ProductUser> UserProducts = new ArrayList<>();
        UserProducts.add(new ProductUser(Long.valueOf(1), 1, new Product(Long.valueOf(1), "Speedpoint", Double.valueOf(400))));
        UserProducts.add(new ProductUser(Long.valueOf(2), 1, new Product(Long.valueOf(2), "Speedee", Double.valueOf(200))));
        UserProducts.add(new ProductUser(Long.valueOf(3), 1, new Product(Long.valueOf(1), "Speedpoint", Double.valueOf(400))));
        UserProducts.add(new ProductUser(Long.valueOf(4), 1, new Product(Long.valueOf(2), "Speedee", Double.valueOf(200))));
        UserProducts.add(new ProductUser(Long.valueOf(5), 1, new Product(Long.valueOf(1), "Speedpoint", Double.valueOf(400))));
        when(productUserRepository.findProductByUserId(Long.getLong("1"))).thenReturn(UserProducts);
        List<Product> UserSelectedProducts = new ArrayList<>();
        UserSelectedProducts.add(new Product(Long.valueOf(1), "Speedpoint", Double.valueOf(400)));
        UserSelectedProducts.add(new Product(Long.valueOf(2), "Speedee", Double.valueOf(200)));
        UserSelectedProducts.add(new Product(Long.valueOf(1), "Speedpoint", Double.valueOf(400)));
        UserSelectedProducts.add(new Product(Long.valueOf(2), "Speedee", Double.valueOf(200)));
        UserSelectedProducts.add(new Product(Long.valueOf(1), "Speedpoint", Double.valueOf(400)));
        assertEquals(UserSelectedProducts.size(), productUserServices.getProductsByCustomer(Long.getLong("1")).size());

    }
}