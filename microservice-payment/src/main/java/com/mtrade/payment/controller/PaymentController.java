package com.mtrade.payment.controller;

import com.mtrade.payment.dao.PaymentDao;
import com.mtrade.payment.exception.ExistingPaymentException;
import com.mtrade.payment.exception.ImpossiblePaymentException;
import com.mtrade.payment.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private PaymentDao paymentDao;

    @Autowired
    public PaymentController(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    public ResponseEntity<Payment> payAnOrder(@RequestBody Payment payment){

        Payment existingPayment = paymentDao.findByOrderId(payment.getOrderId());
        if(existingPayment!= null) throw new ExistingPaymentException("This order is already paid.");

        Payment newPayment = paymentDao.save(payment);
        if(newPayment==null) throw new ImpossiblePaymentException("Impossible to pay for this order. try later.");

        return new ResponseEntity<Payment>(payment , HttpStatus.CREATED);

    }
}
