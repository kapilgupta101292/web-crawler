package com.example.webcrawler.dao;

import com.example.webcrawler.model.Request;
import com.example.webcrawler.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RequestDaoImpl implements RequestDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public String saveRequest(Request request) {
        request = mongoTemplate.save(request);
        return request.getId();
    }
}
