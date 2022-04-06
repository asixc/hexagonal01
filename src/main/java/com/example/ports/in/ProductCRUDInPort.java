package com.example.ports.in;

import com.example.core.domain.Product;

import java.util.List;

public interface ProductCRUDInPort {

    Product findById(Long id);

    Product save(Product product);

    Product update(Product product);

    void deleteById(Long id);

    List<Product> findAll();
}
