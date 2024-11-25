package com.MockProject.ProductBackend.Services;

import com.MockProject.ProductBackend.Data.Model.Product;
import com.MockProject.ProductBackend.Data.Model.ProductUser;
import com.MockProject.ProductBackend.Data.Model.ProductUserCreate;
import com.MockProject.ProductBackend.Data.Repositories.ProductRepository;
import com.MockProject.ProductBackend.Data.Repositories.ProductUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductUserServices {
    private final ProductUserRepository productUserRepository;
    private final ProductRepository productRepository;

    public ProductUserServices(ProductUserRepository productUserRepository, ProductRepository productRepository) {
        this.productUserRepository = productUserRepository;
        this.productRepository = productRepository;
    }

    public ProductUser SaveProductToUser(ProductUserCreate productUserCreate) {
        //validate the selected product id
        Product product = productRepository.findById(productUserCreate.getPID()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found"));
        ProductUser productUser = new ProductUser(0l,productUserCreate.getUID(),product);
        return productUserRepository.save(productUser);
    }

    public List<Product> getProductsByCustomer(Long UID) {
        return productUserRepository.findProductByUserId(UID).stream().map(ProductUser::getProduct).toList();
    }
}
