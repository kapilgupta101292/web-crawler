package com.example.webcrawler.util;

import com.example.webcrawler.model.Page;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class PageUtil {
    private static Logger LOGGER = LoggerFactory.getLogger("PageUtil");
    public static Page getPage(String URL) {
        try {
            Page page = new Page(URL);
            Document document = null;
            try {
                document = Jsoup.connect(URL).get();
            } catch (IllegalArgumentException ex) {
                LOGGER.error("Error while fetching URL : {} , Error: {} ", URL , ex);
                return null;
            }
            Elements links = document.select("a[href]");
            for (Element link: links) {
                page.getPageLinks().add(link.attr("href"));
            }
            Elements images = document.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
            page.setImageCount(images.size());
            page.setTitle(document.title());
            return page;
        } catch (IOException e) {
            LOGGER.error("Error : {}  while parsing the URL: {}", e, URL);
        }
        return null;

    }

//    public static void main(String[] args) {
//        //1. Pick a URL from the frontier
////        new PageUtil().getPageLinks("https://www.springtutorialpoint.com");
//    }

}
