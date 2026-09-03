package ru.edu.games.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.edu.games.onlinestore.entity.OrderItemEntity;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {
}
