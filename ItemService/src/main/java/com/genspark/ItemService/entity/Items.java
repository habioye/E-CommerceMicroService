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

    private Long id;
    private String description;
    private int price;
    private int reviewId;
    private int vendorId;
    private double score;

}