package com.example.webcrawler.util;

import com.example.webcrawler.model.Page;
import com.example.webcrawler.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;

public class Crawler implements Runnable {

    @Autowired
    private PageService pageService;
    private String baseUrl;
    private Integer depth;
    private String requestId;

    public Crawler(String baseUrl, Integer depth, String requestId) {
        this.baseUrl = baseUrl;
        this.depth = depth;
        this.requestId = requestId;
    }
    @Override
    public void run() {
        Page page = PageUtil.getPage(baseUrl);
        page.setLevel(depth);
        page.setRequestId(requestId);
        pageService.saveChildLinks(page);
    }
}
