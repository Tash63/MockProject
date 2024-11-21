package com.MockProject.ProductFrontend.Model.Clients;

import com.MockProject.ProductFrontend.Model.Product;
import com.MockProject.ProductFrontend.Model.ProductUser;
import com.MockProject.ProductFrontend.Model.ProductUserCreate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "ProductUser", url = "${app.ProductUser.url}")
public interface ProductUserClient {
    @RequestMapping(method = RequestMethod.POST, value = "${app.ProductUser.endpoints.save}")
    public ProductUser saveProductToUser(@RequestBody ProductUserCreate productUserCreate);

    @RequestMapping(method = RequestMethod.GET, value = "${app.ProductUser.endpoints.getUserProducts}")
    public List<Product> getProductsByUser(@PathVariable("Id") Integer Id);
}
