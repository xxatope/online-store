package ru.edu.games.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.edu.games.onlinestore.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
