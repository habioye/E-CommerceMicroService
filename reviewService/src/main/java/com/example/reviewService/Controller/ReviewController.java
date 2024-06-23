package com.example.reviewService.Controller;


import com.example.reviewService.Entity.Review;
import com.example.reviewService.Service.ReviewServiceImpl;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewServiceImpl reviewService;

    @GetMapping("/")
    public List<Review> getReviews(){
        //gets all the reviews
        return this.reviewService.getReviews();
    }

    @PostMapping
    public Review addReview(@RequestBody Review review){
        //add a review
        return this.reviewService.createReview(review);
    }

    @PutMapping
    public Review updateReview(@RequestBody Review review){

        return this.reviewService.updateReview(review);
    }

    @DeleteMapping
    public String deleteReview(@RequestBody Long reviewId){
        return this.reviewService.deleteReview(reviewId);
    }

    @GetMapping("/product/{productId}")
    public List<Review> getProductReview(@PathVariable Long productId){
        return this.reviewService.getProductReview(productId);
    }

    @GetMapping("/{reviewId}")
    public Review getOneReview(@PathVariable Long reviewId){
        return this.reviewService.getOneReview(reviewId);

    }


}
