package com.example.cart_service.service;

import com.example.cart_service.entity.Cart;
import com.example.cart_service.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository repo;

    public Cart addCart(Cart cart) {
        return repo.save(cart);
    }

    public Cart getCartByUserId(int userId){
        return repo.findByUserId(userId);
    }

}
