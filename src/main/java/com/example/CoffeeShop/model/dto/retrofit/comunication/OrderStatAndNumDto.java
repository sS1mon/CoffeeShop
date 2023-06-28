package com.example.CoffeeShop.model.dto.retrofit.comunication;

import com.example.CoffeeShop.model.entity.Order;
import com.example.CoffeeShop.model.entity.Status;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderStatAndNumDto {
    private Long id;
    private Status status;

    public OrderStatAndNumDto(Order order) {
        this.id = order.getOrderNumber();
        this.status = order.getStatus();
    }
}
