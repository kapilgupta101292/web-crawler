package com.example.webcrawler.dao;

import com.example.webcrawler.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Queue;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<User> getAllUsers() {
        return mongoTemplate.findAll(User.class);
    }

    public User getUserByFirstName(String firstName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("firstName").is(firstName));
        return mongoTemplate.findOne(query, User.class);
    }

    public User addNewUser(User user) {
        mongoTemplate.save(user);
        return user;
    }
}
