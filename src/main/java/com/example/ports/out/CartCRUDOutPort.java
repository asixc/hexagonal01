package com.example.ports.out;

import com.example.core.domain.Cart;

public interface CartCRUDOutPort {

    Cart findById(Long id);

    Cart save(Cart cart);

    Cart update(Cart cart);

    void deleteById(Long id);

}
