package com.example.CoffeeShop.filter;

import com.example.CoffeeShop.model.dto.user.comunication.OrderDto;
import com.example.CoffeeShop.model.entity.Milk;
import com.example.CoffeeShop.model.entity.Size;
import com.example.CoffeeShop.model.entity.Type;
import org.springframework.stereotype.Service;

@Service
public class FilterForServiceImpl implements FilterForService{
    public Type coffeeType(OrderDto orderDto){
        return switch (orderDto.getType().toLowerCase()) {
            case "espresso" -> Type.ESPRESSO;
            case "lungo", "espresso lungo", "long_black", "long black" -> Type.LONG_BLACK;
            case "latte" -> Type.LATTE;
            case "cappuccino" -> Type.CAPPUCCINO;
            default -> throw new IllegalArgumentException("We don't serve this type of coffee. Chose one of following" +
                    "\nChose one of the following: long black, espresso, cappuccino, latte");
        };
    }

    public Milk milkType(OrderDto orderDto){
        if (coffeeType(orderDto) == Type.LATTE || coffeeType(orderDto) == Type.CAPPUCCINO){
            return switch (orderDto.getMilk().toLowerCase()){
                case "cow", "cow milk", "cow_milk" -> Milk.COW_MILK;
                case "soy", "soy milk", "soy_milk" -> Milk.SOY_MILK;
                case "almond", "almond milk", "almond_milk" -> Milk.ALMOND_MILK;
                default -> throw new IllegalArgumentException("Please choose one of the following: cow milk, soy milk or almond milk.");
            };
        }
        return null;
    }

    public Size coffeeSize(OrderDto orderDto){
        return switch (orderDto.getSize().toLowerCase()){
            case "small" -> Size.SMALL;
            case "medium" -> Size.MEDIUM;
            case "large", "big" -> Size.LARGE;
            default -> throw new IllegalArgumentException("We have only 3 sizes " +
                    "\nplease choose one of the following: small, large, medium");
        };
    }
}
