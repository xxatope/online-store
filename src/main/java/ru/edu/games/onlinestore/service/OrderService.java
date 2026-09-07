package ru.edu.games.onlinestore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.edu.games.onlinestore.dto.CreateOrderDto;
import ru.edu.games.onlinestore.dto.OrderItemDto;
import ru.edu.games.onlinestore.entity.*;
import ru.edu.games.onlinestore.repository.OrderItemRepository;
import ru.edu.games.onlinestore.repository.OrderRepository;
import ru.edu.games.onlinestore.repository.ProductRepository;
import ru.edu.games.onlinestore.repository.UserRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderEntity createOrder(CreateOrderDto createOrderDto){

        UserEntity user = userRepository.findById(createOrderDto.getUserId())
                .orElseThrow(() -> new RuntimeException("Пользователь не найден! "));
        OrderEntity order = new OrderEntity();
        order.setCreatedAt(LocalDateTime.now());
        order.setUser(user);
        order.setStatus(Status.NEW);
        order = orderRepository.save(order);
        for (OrderItemDto itemDto : createOrderDto.getItems()){
            ProductEntity product = productRepository.findById(itemDto.getProductId())
                    .orElseThrow(()-> new RuntimeException("Товар не найден!") );
            OrderItemEntity item = new OrderItemEntity();
            item.setOrder(order);
            item.setPrice(product.getPrice());
            item.setProduct(product);
            item.setQuantity(itemDto.getQuantity());
            item.setProductName(product.getName());
            orderItemRepository.save(item);
        }
        return order;
    }

    public OrderEntity getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Заказ не найден"));
    }

}
