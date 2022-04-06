package com.example.ports.out;

import com.example.core.domain.Cart;

import java.util.List;

public interface CartCRUDOutPort {

    Cart findById(Long id);

    Cart save(Cart cart);

    Cart update(Cart cart);

    void deleteById(Long id);

    List<Cart> findAll();

    List<Cart> findAllCartsPaid();

}
