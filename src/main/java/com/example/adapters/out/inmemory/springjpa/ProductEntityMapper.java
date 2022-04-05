package com.example.adapters.out.inmemory.springjpa;

import com.example.core.domain.Product;

public interface ProductEntityMapper {

    static ProductEntity of(Product product){
        return new ProductEntity(
                product.getId(), product.getName(), product.getCategory(),
                product.getPrice(),product.getCost(), product.getStock(),
                product.getCreationDate()
        );
    }

    static Product of(ProductEntity pe){
        return new Product(
                pe.getId(), pe.getName(), pe.getCategory(),
                pe.getPrice(),pe.getCost(), pe.getStock(),
                pe.getCreationDate());
    }
}
