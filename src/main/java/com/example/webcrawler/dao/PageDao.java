package com.example.webcrawler.dao;

import com.example.webcrawler.model.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageDao {
    List<Page> getAllPages();
//    Page getPageByFirstName(String firstName);
    Page addNewPage(Page page);
}
