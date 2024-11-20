package com.MockProject.ProductFrontend.Model.Services;

import com.MockProject.ProductFrontend.Model.Clients.ProductClient;
import com.MockProject.ProductFrontend.Model.Clients.ProductUserClient;
import com.MockProject.ProductFrontend.Model.Product;
import com.MockProject.ProductFrontend.Model.ProductUser;
import com.MockProject.ProductFrontend.Model.ProductUserCreate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class ProductUserService {
    private Long Id;
    final private ProductUserClient productUserClient;

    public ProductUserService(ProductUserClient productUserClient) {
        this.productUserClient = productUserClient;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public ProductUser SaveProductToUser(ProductUserCreate productUserCreate) {
        //save the selected product to the user
        return productUserClient.saveProductToUser();
    }

    public List<Product> getProductsByUser(Long Id) {
        //get all the products that a user has applied for
        return productUserClient.getProductsByUser(Id);
    }
}
