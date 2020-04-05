package com.example.webcrawler.service;

import com.example.webcrawler.dao.RequestDao;
import com.example.webcrawler.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executor;

@Service
public class CrawlServiceImpl implements CrawlService{

    @Autowired
    RequestDao requestDao;

    @Override
    public String submitRequest(String URL, Integer depth) {
        Request request = new Request(URL, depth);
        String requestId = requestDao.saveRequest(request);
        return requestId;
    }
}
