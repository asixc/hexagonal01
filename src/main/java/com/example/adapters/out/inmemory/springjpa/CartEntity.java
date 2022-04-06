package com.example.adapters.out.inmemory.springjpa;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "carts")
public class CartEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clientId;
    @CreationTimestamp
    private LocalDateTime created;
    private UUID idPayment;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<ProductEntity> products = new ArrayList<>();

    public CartEntity() {
    }

    public CartEntity(Long id, Long clientId, LocalDateTime created, UUID idPayment, List<ProductEntity> products) {
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

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }
}
