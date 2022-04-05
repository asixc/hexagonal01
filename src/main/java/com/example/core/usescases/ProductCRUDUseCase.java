package com.example.core.usescases;

import com.example.core.domain.Product;
import com.example.ports.in.ProductCRUDInPort;
import com.example.ports.out.ProductCRUDOutPort;

public class ProductCRUDUseCase implements ProductCRUDInPort {

    private ProductCRUDOutPort port;

    public ProductCRUDUseCase(ProductCRUDOutPort productCrudOutPort) {
        this.port = productCrudOutPort;
    }

    @Override
    public Product findById(Long id) {
        return this.port.findById(id);
    }

    @Override
    public Product save(Product product) {
        return port.save(product);
    }

    @Override
    public Product update(Product product) {
        return this.port.update(product);
    }

    @Override
    public void deleteById(Long id) {
        this.port.deleteById(id);
    }
}
