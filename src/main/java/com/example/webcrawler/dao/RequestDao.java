package com.example.webcrawler.dao;

import com.example.webcrawler.model.Page;
import com.example.webcrawler.model.Request;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestDao {
    String saveRequest(Request request);
}
