package ru.edu.games.onlinestore.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String email;

    private String password;

    @OneToMany(mappedBy = "user")
    private List<OrderEntity> orders;

    @Enumerated(EnumType.STRING)
    private Role role;

    public UserEntity(){}
}
