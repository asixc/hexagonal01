package com.example.core.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cart {

    private Long id;
    private Long clientId;
    private LocalDateTime created;
    private UUID idPayment;
    private List<Product> products = new ArrayList<>();

    public Cart() {
    }

    public Cart(Long id, Long clientId, LocalDateTime created, UUID idPayment, List<Product> products) {
        this.id = id;
        this.clientId = clientId;
        this.created = created;
        this.idPayment = idPayment;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public UUID getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(UUID idPayment) {
        this.idPayment = idPayment;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", created=" + created +
                ", idPayment=" + idPayment +
                '}';
    }
}
