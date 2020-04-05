package com.example.webcrawler.service;

import com.example.webcrawler.model.User;

public interface UserService {
    public User findByFirstName(String firstName);
}
