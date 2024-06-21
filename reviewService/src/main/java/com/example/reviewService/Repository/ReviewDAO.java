package com.example.reviewService.Repository;

import com.example.reviewService.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewDAO extends JpaRepository<Review, Long> {
}
