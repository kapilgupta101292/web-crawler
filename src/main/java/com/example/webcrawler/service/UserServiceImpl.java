package com.example.webcrawler.service;

import com.example.webcrawler.dao.UserDao;
import com.example.webcrawler.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    public User findByFirstName(String firstName) {
        return userDao.getUserByFirstName(firstName);
    }
}
