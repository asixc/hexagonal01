package com.example.core.domain;

import java.time.LocalDateTime;

public class Product {

    private Long id;
    private String name;
    private String category;
    private Double price;
    private Double cost;
    private Integer stock;
    private LocalDateTime creationDate;

    public Product() {
    }

    public Product(Long id, String name, String category, Double price, Double cost, Integer stock, LocalDateTime creationDate) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.cost = cost;
        this.stock = stock;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public void reduceStock() {
        this.stock--;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
