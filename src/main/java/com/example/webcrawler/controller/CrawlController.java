package com.example.webcrawler.controller;

import com.example.webcrawler.model.Page;
import com.example.webcrawler.service.CrawlService;
import com.example.webcrawler.util.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crawlRequest")
public class CrawlController {

    private final static Logger LOGGER = LoggerFactory.getLogger(CrawlController.class);

    @Autowired
    CrawlService crawlService;

    @RequestMapping("/submit")
    public ResponseEntity<String> submitCrawlRequest(@RequestParam(name = "url", required = true) String URL,
                                                      @RequestParam(name = "depth", required = true) Integer depth) {
        LOGGER.debug("Getting Page with URL {}", URL);
        try {
            String requestId = crawlService.submitRequest(URL, depth);
            return new ResponseEntity<String>(requestId, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<String>("-1", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
