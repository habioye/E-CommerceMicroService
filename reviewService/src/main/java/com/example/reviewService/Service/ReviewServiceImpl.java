package com.example.reviewService.Service;

import com.example.reviewService.Entity.Review;
import com.example.reviewService.Repository.ReviewDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl {
    private ReviewDAO reviewDAO;
    public ReviewServiceImpl(ReviewDAO reviewDAO){
        this.reviewDAO = reviewDAO;
    }

    Review createReview(Review review){
        return this.reviewDAO.save(review);
    }
    List<Review> getReviews(){
        return this.reviewDAO.findAll();
    }
    Review getOne(Long id){
        return this.reviewDAO.findById(id).orElseThrow(()->new RuntimeException("No reviews found"));
    }

    List<Review> getProductReview(Long productId){
        return this.reviewDAO.findByProductId(productId);
    }
}
