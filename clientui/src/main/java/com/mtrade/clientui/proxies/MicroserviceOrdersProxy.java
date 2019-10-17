package com.mtrade.clientui.proxies;

import com.mtrade.clientui.beans.OrderBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "microservice-orders" )
@RibbonClient(name = "microservice-orders" )
public interface MicroserviceOrdersProxy {


    @PostMapping("/orders")
    public OrderBean addOrder(@RequestBody OrderBean order);
}
