package com.example.CoffeeShop.service;

import com.example.CoffeeShop.model.dto.retrofit.comunication.BaristaOrderResponseDto;
import com.example.CoffeeShop.model.entity.Order;

import java.io.IOException;

public interface Communicator {
   BaristaOrderResponseDto giveOrderToBarista(Order order) throws IOException;
}
