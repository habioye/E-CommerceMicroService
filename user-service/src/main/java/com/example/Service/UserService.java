package com.example.Service;

import com.example.Repository.UserDAO;
import com.example.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;
    // Creates a service from UserDAO

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
    public void deleteById(Long id) {
        this.userDAO.deleteById(id);
    }

}
