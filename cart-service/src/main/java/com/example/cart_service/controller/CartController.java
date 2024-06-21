package com.example.cart_service.controller;

import com.example.cart_service.entity.Cart;
import com.example.cart_service.service.CartService;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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

    @GetMapping("")
    public ResponseEntity getAllCarts() {
        return ResponseEntity.ok(service.getAllCarts());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getCartByUserId(@PathVariable int userId) {

        Cart result = service.getCartByUserId(userId);

        if (result == null)
            return ResponseEntity.status(404).body("Error: Failed to find cart with user ID: " + userId);

        return ResponseEntity.ok(result);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> addProductToCart(@PathVariable int userId, @RequestBody int productId) {

        Cart result = service.getCartByUserId(userId);
        if (result == null)
            return ResponseEntity.status(404).body("Error: Failed to find cart with user ID: " + userId);

        // Add new product ID to cart
        ArrayList<Integer> productIds = result.getProductIds();
        productIds.add(productId);
        result.setProductIds(productIds);
        result = service.updateCart(result);

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteCartByUserId(@PathVariable int userId) {

        Cart result = service.getCartByUserId(userId);
        if (result == null)
            return ResponseEntity.status(404).body("Error: Failed to delete; can't find cart with user ID: " + userId);

        service.deleteCartByUserId(userId);
        return ResponseEntity.ok("Cart successfully deleted");
    }

}
