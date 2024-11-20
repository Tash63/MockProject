package com.MockProject.ProductFrontend.Model.Clients;

import com.MockProject.ProductFrontend.Model.Product;
import com.MockProject.ProductFrontend.Model.ProductUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "ProductUser", url = "http://localhost:8081/api/user")
public interface ProductUserClient {
    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public ProductUser saveProductToUser();

    @RequestMapping(method = RequestMethod.GET, value = "/{Id}")
    public List<Product> getProductsByUser(@PathVariable("Id") Long Id);
}
