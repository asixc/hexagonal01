package com.example.adapters.in.api.rest;

import com.example.core.domain.Product;
import com.example.ports.in.ProductCRUDInPort;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductCRUDInPort productPort;
    private static final Log log = LogFactory.getLog(ProductController.class);

    public ProductController(ProductCRUDInPort productPort) {
        this.productPort = productPort;
    }

    @PostMapping()
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO){
        //log.debug("Save Product: [{}]", productDTO.toString());
        Product productDB = this.productPort.save(ProductWebMapper.of(productDTO));
        return ResponseEntity.ok(ProductWebMapper.of(productDB));
    }

    @PutMapping()
    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO productDTO){
        Product productDB = this.productPort.update(ProductWebMapper.of(productDTO));
        return ResponseEntity.ok(ProductWebMapper.of(productDB));
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> read(@PathVariable Long id){
        Product productDB = this.productPort.findById(id);
        return productDB != null ? ResponseEntity.ok(ProductWebMapper.of(productDB)) : ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ProductDTO> delete(@PathVariable Long id){
        this.productPort.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
