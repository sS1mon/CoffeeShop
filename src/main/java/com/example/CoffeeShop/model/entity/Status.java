package com.example.CoffeeShop.model.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Status {
    WAITING("Waiting ..."),
    IN_PREPARATION("In preparation ..."),
    FINISHED("Finished"),
    PICKED_UP("Picked up");

    private final String displayName;
}
