package com.mtrade.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ExistingPaymentException extends RuntimeException {

    public ExistingPaymentException(String message) {
        super(message);
    }
}
