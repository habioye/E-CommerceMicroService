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
    private long id;

    @Column(unique = true)
    private long userId;

    private ArrayList<Long> itemIds;

    // Takes just a user ID
    // Cart ID will be auto-generated
    public Cart(long userId) {
        this(0, userId, new ArrayList<Long>());
    }

}
