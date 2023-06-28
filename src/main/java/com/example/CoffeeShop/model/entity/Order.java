package com.example.CoffeeShop.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long orderNumber;
    private Type coffeeType;
    private Size coffeeSize;
    private Milk typeOfMilk;
    private Boolean takeaway;
    private Double price;
    private Status status;

    public Order(Type type, Size size, Milk milk, Boolean takeaway) {
        this.coffeeType = type;
        this.coffeeSize = size;
        this.typeOfMilk = milk;
        this.takeaway = takeaway;
        this.price = type.getPrice();
        //default is "waiting", until barista starts doing the order
        this.status = Status.WAITING;
    }
}
