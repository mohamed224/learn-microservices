package com.mtrade.clientui.proxies;

import com.mtrade.clientui.beans.PaymentBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "microservice-payments" , url = "localhost:9003")
public interface MicroservicePaymentsProxy {

    @PostMapping("/payments")
    public ResponseEntity<PaymentBean> payAnOrder(@RequestBody PaymentBean paymentBean);
}
