package com.mtrade.clientui.proxies;

import com.mtrade.clientui.beans.OrderBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "microservice-orders" ,url = "localhost:9002")
public interface MicroserviceOrdersProxy {


    @PostMapping("/orders")
    public OrderBean addOrder(@RequestBody OrderBean order);
}
