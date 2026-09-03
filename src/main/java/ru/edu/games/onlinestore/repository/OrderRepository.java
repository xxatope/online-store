package ru.edu.games.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.edu.games.onlinestore.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
