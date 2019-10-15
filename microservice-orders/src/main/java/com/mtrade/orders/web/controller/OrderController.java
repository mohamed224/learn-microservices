package com.mtrade.orders.web.controller;

import com.mtrade.orders.dao.OrderDao;
import com.mtrade.orders.model.Order;
import com.mtrade.orders.web.exception.CanNotAddOrderException;
import com.mtrade.orders.web.exception.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
public class OrderController {

    private OrderDao orderDao;

    @Autowired
    public OrderController(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> addOrder(@RequestBody Order order){

        Order newOrder= orderDao.save(order);
        if(newOrder==null) throw new CanNotAddOrderException("You can not add this order.");

        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    @GetMapping("/orders/{id}")
    public Optional<Order> findOrderById(@PathVariable int id){
        Optional<Order> order = orderDao.findById(id);
        if(!order.isPresent()) throw new OrderNotFoundException("Order with id : "+id+" do not found");
        return order;
    }
}
