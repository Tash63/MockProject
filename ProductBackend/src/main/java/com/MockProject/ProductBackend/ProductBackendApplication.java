package com.MockProject.ProductBackend;

import com.MockProject.ProductBackend.Data.Model.ProductUser;
import com.MockProject.ProductBackend.Data.Model.ProductUserCreate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class ProductBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductBackendApplication.class, args);
    }

}
