package com.MockProject.ProductFrontend.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("/apply")
    public String apply() {
        return "apply";
    }
}
