package com.MockProject.ProductFrontend.Controller;

import com.MockProject.ProductFrontend.Model.Clients.ProductClient;
import com.MockProject.ProductFrontend.Model.Services.ProductServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    private final ProductServices productServices;

    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }

    @GetMapping("/apply")
    public String apply() {
        return "apply";
    }
}
