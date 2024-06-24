package com.genspark.ItemService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;
    private String description;
    private double price;
    private int reviewId;
    private int vendorId;
    private double score;

    
}