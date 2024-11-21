package com.MockProject.ProductFrontend.Model.Clients;

import com.MockProject.ProductFrontend.Model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "Product", url = "${app.product.url}")
public interface ProductClient {
    @RequestMapping(method = RequestMethod.GET, value = "${app.product.endpoints.getall}")
    List<Product> getAllProducts();
}
