package com.example.webcrawler.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document("request")
public class Request {
    @Id
    private String id;
    private Integer depth;
    private String link;
    private Integer status;

    public Request(String URL, Integer depth) {
        this.link = URL;
        this.depth = depth;
        this.status = JobStatus.NOT_STARTED.getValue();
    }
}
