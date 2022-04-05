package com.example.adapters.out.inmemory.springjpa;

import com.example.core.domain.Cart;
import com.example.ports.out.CartCRUDOutPort;

import java.util.Optional;

public class CartDAO implements CartCRUDOutPort {

    private final CartRepository cartRepository;

    public CartDAO(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart findById(Long id) {
        Optional<CartEntity> entity = this.cartRepository.findById(id);
        return entity.isPresent() ? CartEntityMapper.of(entity.get()) : null;
    }

    @Override
    public Cart save(Cart cart) {
        CartEntity entity = CartEntityMapper.of(cart);
        this.cartRepository.save(entity);
        return CartEntityMapper.of(entity);
    }

    @Override
    public Cart update(Cart cart) {
        CartEntity entity = CartEntityMapper.of(cart);
        this.cartRepository.save(entity);
        return CartEntityMapper.of(entity);
    }

    @Override
    public void deleteById(Long id) {
        this.cartRepository.deleteById(id);
    }
}
