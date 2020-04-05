package com.example.webcrawler.service;

import com.example.webcrawler.dao.PageDao;
import com.example.webcrawler.model.JobStatus;
import com.example.webcrawler.model.Page;
import com.example.webcrawler.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageServiceImpl implements PageService{
    @Autowired
    private PageDao pageDao;

    public Page addNewPage(String URL) {
        return pageDao.addNewPage(PageUtil.getPage(URL));
    }

    public void saveChildLinks(Page page) {
        for(String url: page.getPageLinks()) {
            Page p1 = new Page(url);
            p1.setRequestId(page.getRequestId());
            p1.setStatus(JobStatus.NOT_STARTED.getValue());
            p1.setLevel(page.getLevel()+1);
            pageDao.upsert(p1);
        }
    }

}
