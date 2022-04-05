package com.example.adapters.in.api.rest;

import com.example.core.domain.Cart;

import java.util.Collections;
import java.util.stream.Collectors;

public interface CartWebMapper {

    static CartDTO of(Cart cart){
        if (cart != null) {
            return new CartDTO(cart.getId(), cart.getClientId(), cart.getCreated(), cart.getIdPayment(), cart.getProducts().stream().map(ProductWebMapper::of).collect(Collectors.toList()));
        }
        return null;
    }

    static Cart of(CartDTO cartDTO){
        return new Cart(cartDTO.id(), cartDTO.clientId(), cartDTO.created(), cartDTO.idPayment(), cartDTO.products() == null ? Collections.emptyList() : cartDTO.products().stream().map(ProductWebMapper::of).collect(Collectors.toList()) );
    }
}
