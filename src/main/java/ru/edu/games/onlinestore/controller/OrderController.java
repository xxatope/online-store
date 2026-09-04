package ru.edu.games.onlinestore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.edu.games.onlinestore.dto.CreateOrderDto;
import ru.edu.games.onlinestore.entity.OrderEntity;
import ru.edu.games.onlinestore.service.OrderService;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public OrderEntity createOrder(@RequestBody CreateOrderDto createOrderDto){
        return orderService.createOrder(createOrderDto);
    }

}
