package com.example.config;

import com.example.adapters.out.inmemory.springjpa.CartDAO;
import com.example.adapters.out.inmemory.springjpa.CartRepository;
import com.example.adapters.out.inmemory.springjpa.ProductDAO;
import com.example.adapters.out.inmemory.springjpa.ProductRepository;
import com.example.core.usescases.CartCRUDUseCase;
import com.example.core.usescases.ProductCRUDUseCase;
import com.example.ports.in.CartCRUDInPort;
import com.example.ports.in.ProductCRUDInPort;
import com.example.ports.out.CartCRUDOutPort;
import com.example.ports.out.ProductCRUDOutPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ProductDAO productDAO(ProductRepository productRepository){
        return new ProductDAO(productRepository);
    }

    @Bean
    public ProductCRUDInPort productCRUDInPort(ProductCRUDOutPort productCrudOutPort){
        return new ProductCRUDUseCase(productCrudOutPort);
    }

    @Bean
    public CartDAO cartDao(CartRepository cartRepository){
        return new CartDAO(cartRepository);
    }

    @Bean
    public CartCRUDInPort cartCRUDInPort(CartCRUDOutPort cartCrudOutPort){
        return new CartCRUDUseCase(cartCrudOutPort);
    }

}
