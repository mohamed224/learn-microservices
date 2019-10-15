package com.mtrade.orders.web.exception;

import com.mtrade.orders.dao.OrderDao;
import com.mtrade.orders.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class CanNotAddOrderException extends RuntimeException{

    public CanNotAddOrderException(String message) {
        super(message);
    }
}
