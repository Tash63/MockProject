package com.MockProject.ProductFrontend.Controller;

import com.MockProject.ProductFrontend.Model.Clients.ProductUserClient;
import com.MockProject.ProductFrontend.Model.Product;
import com.MockProject.ProductFrontend.Model.ProductUser;
import com.MockProject.ProductFrontend.Model.ProductUserCreate;
import com.MockProject.ProductFrontend.Model.Services.ProductUserService;
import org.bouncycastle.math.raw.Mod;
import org.springframework.boot.Banner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@CrossOrigin(origins = "${app.cors}")
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
    public String menu(@RequestParam(required = false) Integer customerId, Model model) {
        if (customerId != null) {
            productUserService.setId(customerId);
        } else {
            if (productUserService.getId() == null) {
                model.addAttribute("ErrorMessage", "User Not Logged In");
                return "error";
            }
        }
        return "menu";
    }

    @GetMapping("/viewproducts")
    public String viewproducts(Model model) {
        if (productUserService.getId() == null) {
            model.addAttribute("ErrorMessage", "User Not Logged In");
            return "error";
        }
        List<Product> products = productUserService.getProductsByUser();
        model.addAttribute("products", products);
        return "view_products";
    }

    @PostMapping("/addproduct")
    //indicate that this endpoint is only retuing data and not a view
    @ResponseBody
    public void saveproduct(@RequestParam Long pid) {
        //create a Product user create request model
        productUserService.SaveProductToUser(pid);
    }
}
