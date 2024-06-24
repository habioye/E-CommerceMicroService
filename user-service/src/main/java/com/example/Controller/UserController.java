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
    private ReviewClient reviewClient;

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return this.userService.getUsers();
    }

    @GetMapping("/getUser/{id}")
    public User getUserById(@Pathvariable Long id) {

    }

    @PostMapping("/addReview")
    public Review addReview(@RequestBody Review review){
        return ReviewClient.addReview(review);
    }

    @PutMapping("/updateReview")
    public Review updateReview(@RequestBody Review review){
        return ReviewClient.updateReview(review);
    }

    @DeleteMapping("/deleteReview")
    public String deleteReview(@PathVariable Long reviewId) {
        ReviewClient.deleteById(reviewId);
        return "Review has been deleted";
    }


    @PutMapping("/updateUser")
            public User updateUser(RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{userId}")
    public String deleteuser(@PathVariable Long userId){
        //deletes user by userId

        return this.userService.deleteById(userId);
    }


    public List<Review> getProductReview(@PathVariable Long productId){
        return this.reviewService.getProductReview(productId);
    }

    @GetMapping("/{reviewId}")
    public Review getOneReview(@PathVariable Long reviewId){
        return this.reviewService.getOneReview(reviewId);

    }


}
