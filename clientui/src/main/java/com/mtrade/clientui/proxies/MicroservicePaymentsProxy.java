package com.mtrade.clientui.proxies;

import com.mtrade.clientui.beans.PaymentBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "microservice-payments")
@RibbonClient(name="microservice-payments")
public interface MicroservicePaymentsProxy {

    @PostMapping("/payments")
    public ResponseEntity<PaymentBean> payAnOrder(@RequestBody PaymentBean paymentBean);
}
