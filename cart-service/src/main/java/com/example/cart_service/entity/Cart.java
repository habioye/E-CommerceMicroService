package com.example.cart_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private int userId;

    private ArrayList<Integer> productIds;

    public Cart(int userId) {
        this(0, userId, new ArrayList<Integer>());
    }

}
