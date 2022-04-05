package com.example.ports.in;

import com.example.core.domain.Cart;

public interface CartCRUDInPort {

    Cart findById(Long id);

    Cart save(Cart product);

    Cart update(Cart product);

    void deleteById(Long id);
}
