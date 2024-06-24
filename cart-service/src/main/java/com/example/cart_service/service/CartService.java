package com.example.cart_service.service;

import com.example.cart_service.entity.Cart;
import com.example.cart_service.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CartService {

    @Autowired
    private CartRepository repo;

    public Cart addCart(Cart cart) {
        return repo.save(cart);
    }

    public ArrayList getAllCarts() {
        return (ArrayList) repo.findAll();
    }

    public Cart getCartByUserId(long userId) {
        return repo.findCartByUserId(userId);
    }

    public Cart updateCart(Cart cart) {
        return repo.save(cart);
    }

    public void deleteCartByUserId(long userId) {
        repo.deleteCartByUserId(userId);
    }

}
