package com.MockProject.ProductBackend.Controllers;

import com.MockProject.ProductBackend.Data.Model.Product;
import com.MockProject.ProductBackend.Services.ProductServices;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "${app.cors}")
@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductServices productServices;

    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productServices.getAllProducts();
    }
}
