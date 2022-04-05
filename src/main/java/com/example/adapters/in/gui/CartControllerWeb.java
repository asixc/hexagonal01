package com.example.adapters.in.gui;

import com.example.core.domain.Cart;
import com.example.ports.in.CartCRUDInPort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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
}
