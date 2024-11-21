package com.MockProject.ProductFrontend.Controller;

import com.MockProject.ProductFrontend.Model.Clients.ProductClient;
import com.MockProject.ProductFrontend.Model.Product;
import com.MockProject.ProductFrontend.Model.Services.ProductServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@CrossOrigin(origins = "${app.cors}")
@Controller
public class ProductController {
    private final ProductServices productServices;

    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }

    @GetMapping("/apply")
    public String apply(Model model) {
        //get all products
        List<Product> products = productServices.getAllProducts();
        model.addAttribute("products", products);
        return "apply";
    }

    @GetMapping("/confirm")
    public String confirmApplication(@RequestParam Long pid, Model model) {
        model.addAttribute("pid", pid);
        return "confirmation";
    }
}
