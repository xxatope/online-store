package ru.edu.games.onlinestore.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreatedEvent {

    private Long orderId;
    private String userEmail;
    private BigDecimal totalPrice;
    private LocalDateTime createdAt;
    private int itemCount;

}
