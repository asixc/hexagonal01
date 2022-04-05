package com.example.adapters.out.inmemory.springjpa;

import com.example.core.domain.Cart;

import java.util.stream.Collectors;

public interface CartEntityMapper {

    static CartEntity of(Cart cart){
        return new CartEntity(
                cart.getId(),
                cart.getClientId(),
                cart.getCreated(),
                cart.getIdPayment(),
                cart.getProducts().stream().map(ProductEntityMapper::of).collect(Collectors.toList())
        );
    }

    static Cart of(CartEntity cart){
        return new Cart(
                cart.getId(), cart.getClientId(), cart.getCreated(), cart.getIdPayment(), cart.getProducts().stream().map(ProductEntityMapper::of).collect(Collectors.toList())
        );
    }
}
