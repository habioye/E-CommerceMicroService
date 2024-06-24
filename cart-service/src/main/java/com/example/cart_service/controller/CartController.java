package com.example.cart_service.controller;

import com.example.cart_service.entity.Cart;
import com.example.cart_service.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService service;

    @PostMapping("")
    public ResponseEntity<?> addCart(@RequestBody long userId) {

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
    public ResponseEntity<?> getCartByUserId(@PathVariable long userId) {

        Cart result = service.getCartByUserId(userId);

        if (result == null)
            return ResponseEntity.status(404).body("Error: Failed to find cart with user ID: " + userId);

        return ResponseEntity.ok(result);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> addItemToCart(@PathVariable long userId, @RequestBody long itemId) {

        Cart result = service.getCartByUserId(userId);
        if (result == null)
            return ResponseEntity.status(404).body("Error: Failed to find cart with user ID: " + userId);

        // Add new item ID to cart
        ArrayList<Long> itemIds = result.getItemIds();
        itemIds.add(itemId);
        result.setItemIds(itemIds);
        result = service.updateCart(result);

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteCartByUserId(@PathVariable long userId) {

        Cart result = service.getCartByUserId(userId);
        if (result == null)
            return ResponseEntity.status(404).body("Error: Failed to delete; can't find cart with user ID: " + userId);

        service.deleteCartByUserId(userId);
        return ResponseEntity.ok("Cart successfully deleted");
    }



}
