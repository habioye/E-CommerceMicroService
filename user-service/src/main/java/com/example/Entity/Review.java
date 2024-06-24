package com.example.reviewService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long reviewId;
    private double score;
    private long itemId;
    private long userId;
    private String username;

    public Review(double score, long itemId, String username, long userId) {
        this.score = score;
        this.itemId = itemId;
        this.username = username;
        this.userId = userId;

    }
}
