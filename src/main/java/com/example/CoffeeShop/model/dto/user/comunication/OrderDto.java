package com.example.CoffeeShop.model.dto.user.comunication;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {
    @NotBlank(message = "Please indicate your desired type of coffee.")
    private String type;
    @NotBlank(message = "Please indicate the size of coffee you would like.")
    private String size;
    private String milk;
    @NotNull(message = "Please indicate if you want takeaway.")
    private Boolean takeaway;
}
