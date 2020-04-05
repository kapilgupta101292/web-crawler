package com.example.webcrawler.controller;

import com.example.webcrawler.model.Page;
import com.example.webcrawler.service.PageService;
import com.example.webcrawler.util.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PageController {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private PageService pageService;

    @GetMapping("/crawl")
    public ResponseEntity<Page> getPage(@RequestParam(name = "url", required = true) String URL,
                                  @RequestParam(name = "depth", required = true) Integer depth) {
        LOGGER.debug("Getting Page with URL {}", URL);
        try {
            Page page = pageService.addNewPage(URL);
            return new ResponseEntity<Page>(page, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<Page>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
