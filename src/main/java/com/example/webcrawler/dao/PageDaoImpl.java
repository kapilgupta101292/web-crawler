package com.example.webcrawler.dao;

import com.example.webcrawler.model.Page;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PageDaoImpl implements PageDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Page> getAllPages() {
        return mongoTemplate.findAll(Page.class);
    }

    public Page addNewPage(Page page) {
        Query query = new Query(Criteria.where("_id").is(page.getLink()));
        Document doc = new Document(); // org.bson.Document
        mongoTemplate.getConverter().write(page, doc);
        Update update = Update.fromDocument(doc);
        mongoTemplate.upsert(query, update, "page");
        return page;
    }
}
