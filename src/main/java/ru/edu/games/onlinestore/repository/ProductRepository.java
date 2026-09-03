package ru.edu.games.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.edu.games.onlinestore.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
