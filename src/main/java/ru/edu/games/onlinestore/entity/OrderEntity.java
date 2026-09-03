package ru.edu.games.onlinestore.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "order")
    private List <OrderItemEntity> items;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private LocalDateTime createdAt;

    public OrderEntity(){}

    public Long getId() {
        return id;
    }

    public List<OrderItemEntity> getItems() {
        return items;
    }

    public Status getStatus() {
        return status;
    }

    public UserEntity getUser() {
        return user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setItems(List<OrderItemEntity> items) {
        this.items = items;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
