package com.example.Client;


import com.example.Entity.Review;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface ReviewClient {
    @PostExchange("/review")
    public Review addReview(@RequestBody Review review);

    @PutExchange("/review")
    public Review updateReview(@RequestBody Review review);

    @DeleteExchange("review/{reviewId}")
    public String deleteReview(@PathVariable Long reviewId);

}
