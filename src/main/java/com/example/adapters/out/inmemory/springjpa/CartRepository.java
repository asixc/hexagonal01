package com.example.adapters.out.inmemory.springjpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<CartEntity, Long> {
    List<CartEntity> findByIdPaymentIsNotNull();
}
