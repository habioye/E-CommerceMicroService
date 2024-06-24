package com.example.reviewService.Service;

import com.example.reviewService.Entity.Review;
import com.example.reviewService.Repository.ReviewDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl {
    @Autowired
    private ReviewDAO reviewDAO;
//    public ReviewServiceImpl(ReviewDAO reviewDAO){
//        this.reviewDAO = reviewDAO;
//    }

    public Review createReview(Review review){
        //creates a new review
        return this.reviewDAO.save(review);
    }
    public Review updateReview(Review review){
        //updates existing review
        return this.reviewDAO.save(review);
    }
    public List<Review> getReviews(){
        //finds all the reviews
        return this.reviewDAO.findAll();
    }
    public Review getOneReview(Long reviewId){
        //gets a review by the id
        //but if there isnt one that exist then it throws an exception
        Optional<Review> result = this.reviewDAO.findById(reviewId);
        if(result.isPresent()){
            return result.get();
        }else{
            throw new RuntimeException("No reviews found");
        }
    }

    public List<Review> getItemReview(Long itemId){
        //gets all the reviews from one item
        return this.reviewDAO.findByItemId(itemId);
    }

    public String deleteReview(Long reviewId) {
        //deletes a review by the id
        this.reviewDAO.deleteById(reviewId);
        return "Review has been deleted";
    }

    public List<Review> getReviewByUserId(Long userId) {
        //gets all the reviews thats linked to the userId
        return this.reviewDAO.findByUserId(userId);
    }
}
