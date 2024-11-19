package com.MockProject.ProductBackend.Services;

import com.MockProject.ProductBackend.Data.Model.Product;
import com.MockProject.ProductBackend.Data.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {
    private final ProductRepository productRepository;

    public ProductServices(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
