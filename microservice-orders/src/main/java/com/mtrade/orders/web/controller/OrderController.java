package com.mtrade.orders.web.controller;

import com.mtrade.orders.dao.OrderDao;
import com.mtrade.orders.model.Orderr;
import com.mtrade.orders.web.exception.CanNotAddOrderException;
import com.mtrade.orders.web.exception.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class OrderController {


    private OrderDao orderDao;

    @Autowired
    public OrderController(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @PostMapping("/orders")
    public ResponseEntity<Orderr> addOrder(@RequestBody Orderr orderr){

        Orderr newOrderr = orderDao.save(orderr);
        if(newOrderr ==null) throw new CanNotAddOrderException("You can not add this orderr.");

        return new ResponseEntity<Orderr>(orderr, HttpStatus.CREATED);
    }

    @GetMapping("/orders/{id}")
    public Optional<Orderr> findOrderById(@PathVariable int id){
        Optional<Orderr> order = orderDao.findById(id);
        if(!order.isPresent()) throw new OrderNotFoundException("Orderr with id : "+id+" do not found");
        return order;
    }

    @PutMapping(value = "/orders")
    public void updateOrder(@RequestBody Orderr orderr) {

        orderDao.save(orderr);
    }
}
