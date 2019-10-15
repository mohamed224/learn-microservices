package com.mtrade.clientui.proxies;

import com.mtrade.clientui.beans.ProductBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-products" , url = "localhost:9001")
public interface MicroserviceProductProxy {

    @GetMapping("/products")
    List<ProductBean> productsList();

    @GetMapping("/products/{id}")
    ProductBean findProductById(@PathVariable("id") int id);
}
