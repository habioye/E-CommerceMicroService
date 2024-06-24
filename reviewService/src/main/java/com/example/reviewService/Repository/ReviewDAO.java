package com.example.reviewService.Repository;

import com.example.reviewService.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewDAO extends JpaRepository<Review, Long> {
    List<Review> findByItemId(Long itemId);
}
