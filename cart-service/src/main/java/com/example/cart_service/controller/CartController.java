package com.example.cart_service.controller;

import com.example.cart_service.entity.Cart;
import com.example.cart_service.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService service;

    @GetMapping("")
    public String hello() {
        return "Hello world!";
    }

    @PostMapping("")
    public ResponseEntity<?> addCart(@RequestBody int userId) {

        Cart result = service.addCart(new Cart(userId));

        if (result == null)
            ResponseEntity.status(404).body("Error: Failed to create cart for user ID: " + userId);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getCartByUserId(@PathVariable int userId) {

        Cart result = service.getCartByUserId(userId);

        if (result == null)
            ResponseEntity.status(404).body("Error: Failed to find cart with user ID: " + userId);

        return ResponseEntity.ok(result);
    }

}
