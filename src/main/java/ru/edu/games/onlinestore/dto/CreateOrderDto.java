package ru.edu.games.onlinestore.dto;

import java.util.List;

public class CreateOrderDto {

    private Long userId;
    private List<OrderItemDto> items;

    public CreateOrderDto(){}

    public Long getUserId() {
        return userId;
    }

    public List<OrderItemDto> getItems() {
        return items;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setItems(List<OrderItemDto> items) {
        this.items = items;
    }
}