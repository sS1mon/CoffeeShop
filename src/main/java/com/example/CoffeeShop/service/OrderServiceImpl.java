package com.example.CoffeeShop.service;

import com.example.CoffeeShop.filter.FilterForService;
import com.example.CoffeeShop.model.dto.user.comunication.OrderDto;
import com.example.CoffeeShop.model.dto.user.comunication.OrderResponseDto;
import com.example.CoffeeShop.model.dto.retrofit.comunication.OrderStatAndNumDto;
import com.example.CoffeeShop.model.entity.*;
import com.example.CoffeeShop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService{
    private final FilterForService filterForService;
    private final OrderRepository orderRepository;

    @Override
    public String placeOrder(OrderDto orderDto) {
        try {
            orderRepository.addOrder(new Order(
                    filterForService.coffeeType(orderDto),
                    filterForService.coffeeSize(orderDto),
                    filterForService.milkType(orderDto),
                    orderDto.getTakeaway()));
            return "Your order has been placed";
        }catch (Exception e){
            //Usually it would go to a log file or DB
            //For this purpose I will just send it back as response if something happens
            return e.toString();
        }
    }

    @Override
    public OrderResponseDto checkOrders() {
        List<OrderStatAndNumDto> responseList = new ArrayList<>();
        for (Order x : orderRepository.getAllOrders()){
            responseList.add(new OrderStatAndNumDto(x));
        }
        return new OrderResponseDto(responseList);
    }

    @Override
    public String cancelOrder(Integer idGiven) {
        Long id = Long.valueOf(idGiven);
        Order order = orderRepository.findById(id);
        Order lastOrder = orderRepository.findLastOrder();
        if (null == order){
           if (id < lastOrder.getOrderNumber()){
               return "Your order has been taken away";
           } else {
               return "You didn't create an order yet!";
           }
        }
        return switch (order.getStatus()){
            case WAITING -> deleteFromDb(order,1);
            case IN_PREPARATION -> "You can't cancel, order is being processed";
            case FINISHED -> "Your order is already finished";
            case PICKED_UP -> deleteFromDb(order,0);
        };
    }

    private String deleteFromDb(Order order, int b){
        String msg =  b == 1 ? "Your order has been canceled!" : "Your order has been picked up!";
        try {
            orderRepository.deleteOrder(order);
            return msg;
        }catch (Exception e){
            e.printStackTrace();
            return e.toString();
        }
    }
}