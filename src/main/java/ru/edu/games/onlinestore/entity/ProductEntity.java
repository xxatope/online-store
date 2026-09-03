package ru.edu.games.onlinestore.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class ProductEntity {

    private String name;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    private BigDecimal price;

    public ProductEntity(){}

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
