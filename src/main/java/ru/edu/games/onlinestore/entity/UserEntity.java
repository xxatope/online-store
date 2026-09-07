package ru.edu.games.onlinestore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private List<OrderEntity> orders;

    @Enumerated(EnumType.STRING)
    private Role role;

    public UserEntity(){}

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public Role getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
