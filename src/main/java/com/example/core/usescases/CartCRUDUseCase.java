package com.example.core.usescases;

import com.example.core.domain.Cart;
import com.example.ports.in.CartCRUDInPort;
import com.example.ports.out.CartCRUDOutPort;

import java.util.List;

public class CartCRUDUseCase implements CartCRUDInPort {

    private CartCRUDOutPort port;

    public CartCRUDUseCase(CartCRUDOutPort cartCrudOutPort) {
        this.port = cartCrudOutPort;
    }

    @Override
    public Cart findById(Long id) {
        return this.port.findById(id);
    }

    @Override
    public Cart save(Cart cart) {
        return port.save(cart);
    }

    @Override
    public Cart update(Cart cart) {
        return this.port.update(cart);
    }

    @Override
    public void deleteById(Long id) {
        this.port.deleteById(id);
    }

    @Override
    public List<Cart> getAllCarts() {
        return this.port.findAll();
    }
}
