package org.example.Controller;


import com.example.reviewService.Entity.Review;
import com.example.reviewService.Service.ReviewServiceImpl;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class ReviewController {

    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeClient employeeClient;

    @PutMapping("/user")
    public User 
    @GetMapping("/")
    public List<User> getUsers(){
        return this.userService.getUsers();
    }

    @PostMapping
    public Review addReview(@RequestBody Review review){
        return ReviewClient.addReview(review);
    }

    @PutMapping
    public Review updateReview(@RequestBody Review review){
        return this.reviewService.updateReview(review);
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
