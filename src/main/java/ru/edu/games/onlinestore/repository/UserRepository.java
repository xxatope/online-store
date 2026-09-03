package ru.edu.games.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.edu.games.onlinestore.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
