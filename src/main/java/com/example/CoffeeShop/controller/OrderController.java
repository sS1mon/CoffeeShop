package com.example.CoffeeShop.controller;

import com.example.CoffeeShop.model.dto.user.comunication.OrderDto;
import com.example.CoffeeShop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public ResponseEntity<Object> placeOrder(@RequestBody OrderDto orderDto) {
        return new ResponseEntity<>(orderService.placeOrder(orderDto), HttpStatus.CREATED);
    }

    @PostMapping("/cancel")
    public ResponseEntity<Object> cancelOrder(@RequestParam int id){
        return new ResponseEntity<>(orderService.cancelOrder(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/order")
    public ResponseEntity<Object> orderList(){
        return ResponseEntity.ok().body(orderService.checkOrders());
    }
}