package ru.edu.games.onlinestore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.edu.games.onlinestore.dto.CreateOrderDto;
import ru.edu.games.onlinestore.entity.OrderEntity;
import ru.edu.games.onlinestore.service.OrderService;

import org.springframework.security.core.Authentication;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public OrderEntity createOrder(@RequestBody CreateOrderDto createOrderDto, Principal principal) {
        return orderService.createOrder(createOrderDto, principal.getName());
    }

    @GetMapping("/my")
    public List<OrderEntity> getMyOrders(Principal principal) {
        return orderService.getMyOrders(principal.getName());
    }

    @GetMapping("/{id}")
    public OrderEntity getOrderById(@PathVariable Long id, Authentication authentication) {
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
        return orderService.getOrderById(id, authentication.getName(), isAdmin);
    }
}
