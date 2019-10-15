package com.mtrade.payment.controller;

import com.mtrade.payment.beans.OrderBean;
import com.mtrade.payment.dao.PaymentDao;
import com.mtrade.payment.exception.ExistingPaymentException;
import com.mtrade.payment.exception.ImpossiblePaymentException;
import com.mtrade.payment.model.Payment;
import com.mtrade.payment.proxies.MicroserviceOrdersProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PaymentController {

    private PaymentDao paymentDao;
    private MicroserviceOrdersProxy microserviceOrdersProxy;

    @Autowired
    public PaymentController(PaymentDao paymentDao,
                             MicroserviceOrdersProxy microserviceOrdersProxy) {
        this.paymentDao = paymentDao;
        this.microserviceOrdersProxy = microserviceOrdersProxy;
    }

    @PostMapping("/payments")
    public ResponseEntity<Payment> payAnOrder(@RequestBody Payment payment){

        Payment existingPayment = paymentDao.findByOrderId(payment.getOrderId());
        if(existingPayment!= null) throw new ExistingPaymentException("This order is already paid.");

        Payment newPayment = paymentDao.save(payment);
        if(newPayment==null) throw new ImpossiblePaymentException("Impossible to pay for this order. try later.");

        Optional<OrderBean> orderBean = microserviceOrdersProxy.findOrderById(payment.getOrderId());

        OrderBean order = orderBean.get();

        order.setPaidOrder(true);

        microserviceOrdersProxy.updateOrder(order);


        return new ResponseEntity<Payment>(payment , HttpStatus.CREATED);

    }
}
