package com.example.adapters.out.inmemory.springjpa;

import com.example.core.domain.Product;
import com.example.ports.out.ProductCRUDOutPort;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductDAO implements ProductCRUDOutPort{

    private final ProductRepository productRepository;

    public ProductDAO(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findById(Long id) {
        Optional<ProductEntity> entity = this.productRepository.findById(id);
        return entity.isPresent() ? ProductEntityMapper.of(entity.get()) : null;
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = ProductEntityMapper.of(product);
        this.productRepository.save(entity);
        return ProductEntityMapper.of(entity);
    }

    @Override
    public Product update(Product product) {
        return ProductEntityMapper.of(this.productRepository.save(ProductEntityMapper.of(product)));
    }

    @Override
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll().stream().map(ProductEntityMapper::of).collect(Collectors.toList());
    }
}
