package ru.edu.games.onlinestore.dto;

import java.util.List;

public class CreateOrderDto {


    private List<OrderItemDto> items;

    public CreateOrderDto(){}


    public List<OrderItemDto> getItems() {
        return items;
    }


    public void setItems(List<OrderItemDto> items) {
        this.items = items;
    }
}