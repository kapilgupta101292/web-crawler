package com.example.webcrawler.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document("page")
public class Page {
    @Id
    private String link;
    private Integer level;
    private String requestId;
    private String title;
    private Integer imageCount;
    private List<String> pageLinks;
    private Integer status;

    public Page(String URL) {
        this.link = URL;
        this.pageLinks = new ArrayList<>();
    }
}
