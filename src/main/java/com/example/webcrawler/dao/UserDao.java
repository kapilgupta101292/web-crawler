package com.example.webcrawler.dao;

import com.example.webcrawler.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    List<User> getAllUsers();
    User getUserByFirstName(String firstName);
    User addNewUser(User user);
}
