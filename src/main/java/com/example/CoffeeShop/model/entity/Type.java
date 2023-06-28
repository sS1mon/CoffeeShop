package com.example.CoffeeShop.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Type {
    LONG_BLACK(2.00,"Long Black"),
    LATTE(2.50,"Latte"),
    CAPPUCCINO(2.30,"Cappuccino"),
    ESPRESSO(1.90,"Espresso");

    private final Double price;
    private final String displayName;
}
