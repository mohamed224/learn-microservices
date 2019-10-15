package com.mtrade.payment.proxies;

import com.mtrade.payment.beans.OrderBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@FeignClient(name = "microservice-orders" ,url = "localhost:9002")
public interface MicroserviceOrdersProxy {

    @GetMapping(value = "/orders/{id}")
    Optional<OrderBean> findOrderById(@PathVariable("id") int id);

    @PutMapping("/orders")
    public void updateOrder(@RequestBody OrderBean orderBean);
}
