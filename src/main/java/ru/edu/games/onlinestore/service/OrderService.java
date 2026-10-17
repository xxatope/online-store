package ru.edu.games.onlinestore.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.edu.games.onlinestore.dto.CreateOrderDto;
import ru.edu.games.onlinestore.dto.OrderItemDto;
import ru.edu.games.onlinestore.entity.*;
import ru.edu.games.onlinestore.event.OrderCreatedEvent;
import ru.edu.games.onlinestore.event.OrderEventProducer;
import ru.edu.games.onlinestore.repository.OrderItemRepository;
import ru.edu.games.onlinestore.repository.OrderRepository;
import ru.edu.games.onlinestore.repository.ProductRepository;
import ru.edu.games.onlinestore.repository.UserRepository;

import java.beans.Transient;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderEventProducer orderEventProducer;

    @Transactional
    public OrderEntity createOrder(CreateOrderDto createOrderDto, String userEmail){

        UserEntity user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден! "));


        OrderEntity order = new OrderEntity();
        order.setCreatedAt(LocalDateTime.now());
        order.setUser(user);
        order.setStatus(Status.NEW);
        order = orderRepository.save(order);


        BigDecimal totalPrice = BigDecimal.ZERO;


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

            BigDecimal itemTotal = product.getPrice().multiply(BigDecimal.valueOf(itemDto.getQuantity()));
            totalPrice = totalPrice.add(itemTotal);
        }

        OrderCreatedEvent event = OrderCreatedEvent.builder()
                .orderId(order.getId())
                .userEmail(user.getEmail())
                .totalPrice(totalPrice)
                .createdAt(order.getCreatedAt())
                .itemCount(createOrderDto.getItems().size())
                .build();

        orderEventProducer.sendOrderCreatedEvent(event);

        return order;
    }

    public OrderEntity getOrderById(Long id, String userEmail, boolean isAdmin) {
        OrderEntity order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Заказ не найден"));

        if (!isAdmin && (order.getUser() == null || !order.getUser().getEmail().equals(userEmail))) {
            throw new RuntimeException("У вас нет доступа к этому заказу");
        }
        return order;
    }

    public List<OrderEntity> getMyOrders(String userEmail) {
        return orderRepository.findByUserEmail(userEmail);
    }
}
