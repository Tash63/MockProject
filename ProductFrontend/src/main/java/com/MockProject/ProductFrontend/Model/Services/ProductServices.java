package com.MockProject.ProductFrontend.Model.Services;

import com.MockProject.ProductFrontend.Model.Clients.ProductClient;
import com.MockProject.ProductFrontend.Model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {
    private final ProductClient productClient;

    public ProductServices(ProductClient productClient) {
        this.productClient = productClient;
    }

    public List<Product> getAllProducts() {
        //get all the products
        return productClient.getAllProducts();
    }
}
