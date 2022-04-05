package com.example.adapters.in.gui;

import com.example.core.domain.Cart;
import com.example.ports.in.CartCRUDInPort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class CartControllerWeb {

    private final CartCRUDInPort cartPort;

    public CartControllerWeb(CartCRUDInPort cartPort) {
        this.cartPort = cartPort;
    }

    @GetMapping("/carts")
    public String showCarts(Model model) {
        List<Cart> carts = this.cartPort.getAllCarts();
        model.addAttribute("carts", carts);
        return "cart-list";
    }

    @RequestMapping(value = "/carts/{id}/paid")
    public String markAsPaid(@PathVariable(value = "id") Long id){

        if (id > 0 ){
            final UUID idPayment = UUID.randomUUID();
            var cart = this.cartPort.findById(id);
            cart.setIdPayment(idPayment);
            this.cartPort.update(cart);
        }
        return "redirect:/carts";
    }
}
