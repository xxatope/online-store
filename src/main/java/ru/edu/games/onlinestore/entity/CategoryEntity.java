package ru.edu.games.onlinestore.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public CategoryEntity(){

    }

    @OneToMany(mappedBy = "category")
    private List<ProductEntity> products;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
