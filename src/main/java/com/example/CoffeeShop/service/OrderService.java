package com.example.CoffeeShop.service;

import com.example.CoffeeShop.model.dto.user.comunication.OrderDto;
import com.example.CoffeeShop.model.dto.user.comunication.OrderResponseDto;

public interface OrderService {
    public String placeOrder(OrderDto orderDto);
    public OrderResponseDto checkOrders();
    public String cancelOrder(Integer id);
}
