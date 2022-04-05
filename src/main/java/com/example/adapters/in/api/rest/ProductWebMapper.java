package com.example.adapters.in.api.rest;

import com.example.core.domain.Product;

public interface ProductWebMapper {

    static ProductDTO of(Product product){
        if (product != null) {
            return new ProductDTO(product.getId(), product.getName(), product.getCategory(),
                    product.getPrice(), product.getStock());
        }
        return null;
    }

    static Product of(ProductDTO productDTO){
        return new Product(productDTO.id(), productDTO.name(),
                productDTO.category(), productDTO.price(), null, productDTO.stock(), null);
    }
}
