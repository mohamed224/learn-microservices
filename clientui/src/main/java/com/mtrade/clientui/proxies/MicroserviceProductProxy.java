package com.mtrade.clientui.proxies;

import com.mtrade.clientui.beans.ProductBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-products")
@RibbonClient(name = "microservice-products")
public interface MicroserviceProductProxy {

    @GetMapping("/products")
    List<ProductBean> productsList();

    @GetMapping("/products/{id}")
    ProductBean findProductById(@PathVariable("id") int id);
}
