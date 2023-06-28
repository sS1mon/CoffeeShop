package com.example.CoffeeShop.filter;

import com.example.CoffeeShop.model.dto.user.comunication.OrderDto;
import com.example.CoffeeShop.model.entity.Milk;
import com.example.CoffeeShop.model.entity.Size;
import com.example.CoffeeShop.model.entity.Type;

public interface FilterForService {
    public Type coffeeType(OrderDto orderDto);
    public Milk milkType(OrderDto orderDto);
    public Size coffeeSize(OrderDto orderDto);
}
