package com.example.reviewService.Service;

import com.example.reviewService.Entity.Review;
import com.example.reviewService.Repository.ReviewDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl {
    @Autowired
    private ReviewDAO reviewDAO;
//    public ReviewServiceImpl(ReviewDAO reviewDAO){
//        this.reviewDAO = reviewDAO;
//    }

    public Review createReview(Review review){
        return this.reviewDAO.save(review);
    }
    public Review updateReview(Review review){
        return this.reviewDAO.save(review);
    }
    public List<Review> getReviews(){
        return this.reviewDAO.findAll();
    }
    public Review getOneReview(Long reviewId){
        return this.reviewDAO.findById(reviewId).orElseThrow(()->new RuntimeException("No reviews found"));
    }

    public List<Review> getProductReview(Long productId){
        return this.reviewDAO.findByProductId(productId);
    }
}