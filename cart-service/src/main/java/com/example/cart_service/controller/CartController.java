package com.example.cart_service.controller;

import com.example.cart_service.entity.Cart;
import com.example.cart_service.entity.Items;
import com.example.cart_service.service.CartService;
import com.example.cart_service.client.ItemsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService service;

    @Autowired
    ItemsClient itemsClient;

    // Create a cart for a user; every user has one and only one cart
    @PostMapping("")
    public ResponseEntity<?> addCart(@RequestBody long userId) {

        Cart result = service.getCartByUserId(userId);
        if (result != null)
            return ResponseEntity.status(404).body("Error: Cart already exists for user ID: " + userId);

        result = service.addCart(new Cart(userId));
        if (result == null)
            return ResponseEntity.status(404).body("Error: Failed to create cart for user ID: " + userId);

        return ResponseEntity.ok(result);
    }

    // Find all carts
    @GetMapping("")
    public ResponseEntity getAllCarts() {
        return ResponseEntity.ok(service.getAllCarts());
    }

    // Find cart by its user ID
    @GetMapping("/{userId}")
    public ResponseEntity<?> getCartByUserId(@PathVariable long userId) {

        Cart result = service.getCartByUserId(userId);

        if (result == null)
            return ResponseEntity.status(404).body("Error: Failed to find cart with user ID: " + userId);

        return ResponseEntity.ok(result);
    }

    // Find the items in a user's cart
    @GetMapping("/{userId}/items")
    public ResponseEntity<?> getCartItemsByUserId(@PathVariable long userId) {

        Cart result = service.getCartByUserId(userId);

        if (result == null)
            return ResponseEntity.status(404).body("Error: Failed to find cart with user ID: " + userId);

        ArrayList<Items> items = new ArrayList<>();
        for (long itemId : result.getItemIds()) {
            items.add(itemsClient.findById(itemId));
        }

        return ResponseEntity.ok(items);
    }

    // Add an item to user's cart
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

    // Delete a cart
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteCartByUserId(@PathVariable long userId) {

        Cart result = service.getCartByUserId(userId);
        if (result == null)
            return ResponseEntity.status(404).body("Error: Failed to delete; can't find cart with user ID: " + userId);

        service.deleteCartByUserId(userId);
        return ResponseEntity.ok("Cart successfully deleted");
    }

}
