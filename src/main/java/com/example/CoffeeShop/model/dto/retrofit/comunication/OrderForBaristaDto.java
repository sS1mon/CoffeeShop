package com.example.CoffeeShop.model.dto.retrofit.comunication;

import com.example.CoffeeShop.model.entity.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderForBaristaDto {
    private Long orderNumber;
    private Type coffeeType;
    private Size coffeeSize;
    private Milk typeOfMilk;
    private Boolean takeaway;
    private Double price;
    private Status status;

    public OrderForBaristaDto(Order order) {
        this.orderNumber = order.getOrderNumber();
        this.coffeeType = order.getCoffeeType();
        this.coffeeSize = order.getCoffeeSize();
        this.typeOfMilk = order.getTypeOfMilk();
        this.takeaway = order.getTakeaway();
        this.price = order.getPrice();
        this.status = order.getStatus();
    }
}
