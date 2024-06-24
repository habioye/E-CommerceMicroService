package com.example.Controller;

import com.example.Client.ReviewClient;
import com.example.Service.UserService;
import com.example.Entity.User;
import com.example.reviewService.Entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ReviewClient reviewClient;

    @GetMapping("")
    public String root(){
        return "Hello world!";
    }

    // CRUD methods for user
    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return this.userService.getUsers();
    }

    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable Long id) {
        return this.userService.getOneUser(id);
    }

    @PutMapping("/updateUser")
            public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{userId}")
    public String deleteuser(@PathVariable Long userId){
        //deletes user by userId
        this.userService.deleteById(userId);
        return "User deleted";
    }
    // CRUD methods for reviews
    @PostMapping("/addReview")
    public Review addReview(@RequestBody Review review){
        return reviewClient.addReview(review);
    }

    @PutMapping("/updateReview")
    public Review updateReview(@RequestBody Review review){
        return reviewClient.updateReview(review);
    }

    @DeleteMapping("/deleteReview")
    public String deleteReview(@PathVariable Long reviewId) {
        reviewClient.deleteById(reviewId);
        return "Review has been deleted";
    }
//    public List<Review> getProductReview(@PathVariable Long productId){
//        return this.reviewClient.getProductReview(productId);
//    }
//
//    @GetMapping("/{reviewId}")
//    public Review getOneReview(@PathVariable Long reviewId){
//        return this.reviewClient.getOneReview(reviewId);
//
//    }

}
