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
    // Makes requests to Item service for each item ID
    @GetMapping("/{userId}/items")
    public ResponseEntity<?> getCartItemsByUserId(@PathVariable long userId) {

        Cart result = service.getCartByUserId(userId);

        if (result == null)
            return ResponseEntity.status(404).body("Error: Failed to find cart with user ID: " + userId);

        ArrayList<Items> items = new ArrayList<>();
        ArrayList<ArrayList<Long>> cartItems = result.getItemIds();
        for (ArrayList<Long> cartItem : cartItems) {
            items.add(itemsClient.findById(cartItem.get(0)));   // Index 0 holds the item's ID
        }

        return ResponseEntity.ok(items);
    }

    // Add an item to user's cart
    // If item is already in cart, increment quantity
    @PutMapping("/{userId}")
    public ResponseEntity<?> addItemToCart(@PathVariable long userId, @RequestBody long newItemId) {

        Cart cart = service.getCartByUserId(userId);
        if (cart == null)
            return ResponseEntity.status(404).body("Error: Failed to find cart with user ID: " + userId);

        // Check if cart already contains new item
        // If it does, increment item count
        ArrayList<ArrayList<Long>> cartItems = cart.getItemIds();
        for (ArrayList<Long> cartItem : cartItems) {
            if (cartItem.get(0) == newItemId) {
                long quantity = cartItem.get(1);   // Index 1: quantity
                cartItem.set(1, quantity + 1);

                cart.setItemIds(cartItems);
                cart = service.updateCart(cart);

                return ResponseEntity.ok(cart);
            }
        }

        // Add a new item ID to cart
        ArrayList<Long> newItem = new ArrayList<>();
        newItem.add(newItemId);  // Index 0: Item ID
        newItem.add(1L);         // Index 1: Item quantity

        cartItems.add(newItem);
        cart.setItemIds(cartItems);
        cart = service.updateCart(cart);

        return ResponseEntity.ok(cart);
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
