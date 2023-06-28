package com.example.CoffeeShop.model.dto.user.comunication;

import com.example.CoffeeShop.model.dto.retrofit.comunication.OrderStatAndNumDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class OrderResponseDto {
    private List<OrderStatAndNumDto> orderList;
}
