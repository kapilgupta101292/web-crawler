package com.example.webcrawler.service;

import com.example.webcrawler.model.Page;

public interface PageService {
    public Page addNewPage(String URL);

    public void saveChildLinks(Page page);
}
