package com.MockProject.ProductFrontend.Controller;

import com.MockProject.ProductFrontend.Model.Clients.ProductUserClient;
import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.graphql.ConditionalOnGraphQlSchema;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private final ProductUserClient productUserClient;

    public UserController(ProductUserClient productUserClient) {
        this.productUserClient = productUserClient;
    }

    @GetMapping("/")
    public String LoginPage() {
        return "login";
    }

    @GetMapping("/menu")
    public String menu(@RequestParam Long customerId) {
        System.out.println(customerId);
        return "menu";
    }

    @GetMapping("/viewproducts")
    public String viewproducts() {
        return "view_products";
    }
}
