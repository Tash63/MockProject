package com.MockProject.ProductBackend.Controllers;

import com.MockProject.ProductBackend.Data.Model.Product;
import com.MockProject.ProductBackend.Data.Model.ProductUser;
import com.MockProject.ProductBackend.Data.Model.ProductUserCreate;
import com.MockProject.ProductBackend.Services.ProductUserServices;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "${app.cors}")
@RestController
@RequestMapping("/api/user")
public class ProductUserController {
    private final ProductUserServices productUserServices;

    public ProductUserController(ProductUserServices productUserServices) {
        this.productUserServices = productUserServices;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public ProductUser saveProductToUser(@RequestBody ProductUserCreate productUserCreate) {
        return productUserServices.SaveProductToUser(productUserCreate);
    }

    @GetMapping("/{Id}")
    public List<Product> getProductsForUsers(@PathVariable Long Id) {
        return productUserServices.getProductsByCustomer(Id);
    }
}
