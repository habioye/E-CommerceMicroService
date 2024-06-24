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
        return this.reviewDAO.save(review);
    }
    public Review updateReview(Review review){
        return this.reviewDAO.save(review);
    }
    public List<Review> getReviews(){
        return this.reviewDAO.findAll();
    }
    public Review getOneReview(Long reviewId){
        Optional<Review> result = this.reviewDAO.findById(reviewId);
        if(result.isPresent()){
            return result.get();
        }else{
            throw new RuntimeException("No reviews found");
        }
    }

    public List<Review> getItemReview(Long itemId){
        return this.reviewDAO.findByItemId(itemId);
    }

    public String deleteReview(Long reviewId) {
        this.reviewDAO.deleteById(reviewId);
        return "Review has been deleted";
    }
}
