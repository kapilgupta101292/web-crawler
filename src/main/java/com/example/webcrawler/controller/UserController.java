package com.example.webcrawler.controller;


import com.example.webcrawler.model.User;
import com.example.webcrawler.dao.UserRepository;
import com.example.webcrawler.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value="/{firstName}", method= RequestMethod.GET)
    public User getUser(@PathVariable String firstName) {
        LOGGER.debug("Getting user with Id {}", firstName);
        return userService.findByFirstName(firstName);
    }

}
