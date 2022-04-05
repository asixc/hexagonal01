package com.example.adapters.in.api.rest;

import com.example.core.domain.Cart;
import com.example.ports.in.CartCRUDInPort;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    private final CartCRUDInPort cartPort;
    private static final Log log = LogFactory.getLog(CartController.class);

    public CartController(CartCRUDInPort cartPort) {
        this.cartPort = cartPort;
    }

    @PostMapping()
    public ResponseEntity<CartDTO> save(@RequestBody CartDTO cartDTO){
        //log.debug("Save Product: [{}]", productDTO.toString());
        Cart cartDB = this.cartPort.save(CartWebMapper.of(cartDTO));
        return ResponseEntity.ok(CartWebMapper.of(cartDB));
    }
    // Se deja por hacer para pruebas pero añadir productos y demás se hará desde CartManager
    @PutMapping()
    public ResponseEntity<CartDTO> update(@RequestBody CartDTO cartDTO){
        return ResponseEntity.ok(CartWebMapper.of(
                this.cartPort.update(CartWebMapper.of(cartDTO))
        ));
    }


    @GetMapping("/{id}")
    public ResponseEntity<CartDTO> read(@PathVariable Long id){
        Cart cartDB = this.cartPort.findById(id);
        return cartDB != null ? ResponseEntity.ok(CartWebMapper.of(cartDB)) : ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<CartDTO> delete(@PathVariable Long id){
        this.cartPort.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
