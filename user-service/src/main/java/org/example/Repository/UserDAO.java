package org.example.Repository;

import org.example.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Long> {
    List<User> findByUserId(Long productId);
}
