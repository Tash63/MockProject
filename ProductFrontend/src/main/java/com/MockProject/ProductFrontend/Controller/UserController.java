package com.MockProject.ProductFrontend.Controller;

import com.MockProject.ProductFrontend.Model.Clients.ProductUserClient;
import com.MockProject.ProductFrontend.Model.Product;
import com.MockProject.ProductFrontend.Model.ProductUser;
import com.MockProject.ProductFrontend.Model.ProductUserCreate;
import com.MockProject.ProductFrontend.Model.Services.ProductUserService;
import org.springframework.boot.Banner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@Scope("session")
public class UserController {
    private final ProductUserService productUserService;

    public UserController(ProductUserService productUserService) {
        this.productUserService = productUserService;
    }

    @GetMapping("/")
    public String LoginPage() {
        return "login";
    }

    @GetMapping("/menu")
    public String menu(@RequestParam(required = false) Integer customerId) {
        if (customerId != null) {
            productUserService.setId(customerId);
        }
        return "menu";
    }

    @GetMapping("/viewproducts")
    public String viewproducts(Model model) {
        List<Product> products = productUserService.getProductsByUser();
        model.addAttribute("products", products);
        return "view_products";
    }

    @PostMapping("/addproduct")
    public String saveproduct(@RequestParam Long pid) {
        //create a Product user create request model
        productUserService.SaveProductToUser(pid);
        return "sucess";
    }
}
