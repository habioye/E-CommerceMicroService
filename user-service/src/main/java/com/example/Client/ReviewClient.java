package com.example.Client;


import com.example.reviewService.Entity.Review;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.*;

import java.util.List;

@HttpExchange
public interface ReviewClient {

    //Gives remaining add/update/delete methods for affecting reviews.
    @PostExchange("/review")
    public Review addReview(@RequestBody Review review);

    @PutExchange("/review")
    public Review updateReview(@RequestBody Review review);

    @DeleteExchange("review/{reviewId}")
    public String deleteById(@PathVariable Long reviewId);

}
