package com.example.reviewService.Controller;


import com.example.reviewService.Entity.Review;
import com.example.reviewService.Service.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewServiceImpl reviewService;

    @GetMapping
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
        //updates an existing review
        return this.reviewService.updateReview(review);
    }

    @DeleteMapping("/{reviewId}")
    public String deleteReview(@PathVariable Long reviewId){
        //deletes review by reviewId

        return this.reviewService.deleteReview(reviewId);
    }

    @GetMapping("/product/{itemId}")
    public List<Review> getProductReview(@PathVariable Long itemId){
        //gets the review by productId
        return this.reviewService.getItemReview(itemId);
    }

    @GetMapping("/{reviewId}")
    public Review getOneReview(@PathVariable Long reviewId){
        //gets a review by the id
        return this.reviewService.getOneReview(reviewId);

    }
    @GetMapping("/user/{userId}")
    public List<Review> getReviewByUserId(@PathVariable Long userId){
        return this.reviewService.getReviewByUserId(userId);
    }


}
