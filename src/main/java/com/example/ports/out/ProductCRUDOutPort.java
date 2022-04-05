package com.example.ports.out;

import com.example.core.domain.Product;

public interface ProductCRUDOutPort {

    Product findById(Long id);

    Product save(Product product);

    Product update(Product product);

    void deleteById(Long id);

}
