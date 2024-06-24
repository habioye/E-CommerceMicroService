package org.example.Service;

import org.example.Entity.User;
import org.example.Repository.UserDAO;
import org.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;
//    public ReviewServiceImpl(ReviewDAO reviewDAO){
//        this.reviewDAO = reviewDAO;
//    }

    public User createUser(User user){
        return this.userDAO.save(user);
    }
    public User updateUser(User user){
        return this.userDAO.save(user);
    }
    public List<User> getUsers(){
        return this.userDAO.findAll();
    }
    public User getOneUser(Long reviewId){
        return this.userDAO.findById(reviewId).orElseThrow(()->new RuntimeException("No reviews found"));
    }

    public List<Review> getProductReview(Long productId){
        return this.reviewDAO.findByProductId(productId);
    }
}
