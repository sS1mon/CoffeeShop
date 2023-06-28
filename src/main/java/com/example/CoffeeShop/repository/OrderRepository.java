package com.example.CoffeeShop.repository;

import com.example.CoffeeShop.model.entity.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface OrderRepository {

    List<Order> getAllOrders ();
    void addOrder(Order order);
    void deleteOrder(Order order);
    Order findById(Long id);
    Order findLastOrder();
}
