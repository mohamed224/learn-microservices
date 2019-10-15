package com.mtrade.orders.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class CanNotAddOrderException extends RuntimeException{

    public CanNotAddOrderException(String message) {
        super(message);
    }
}
