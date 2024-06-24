package com.example.cart_service.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Items {

    private Long itemId;
    private String description;
    private int price;
    private int reviewId;
    private int vendorId;
    private double score;

}