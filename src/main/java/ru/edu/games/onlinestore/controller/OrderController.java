package ru.edu.games.onlinestore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/{id}")
    public OrderEntity getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

}
