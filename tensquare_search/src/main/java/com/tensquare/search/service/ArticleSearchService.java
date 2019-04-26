package com.tensquare.search.service;

import com.tensquare.search.dao.ArticleSearchDao;
import com.tensquare.search.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @ClassName: SearchService
 * @Author: lish
 * @Date: 2019/4/25 10:07
 * @Description: 搜索
 */
@Service
public class ArticleSearchService {

    @Autowired
    private ArticleSearchDao articleSearchDao;

    public void save(Article article) {
        articleSearchDao.save(article);
    }

    //根据标题分页查找
    public Page<Article> findByTitleLike(String title, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return articleSearchDao.findbyTitleOrContentLike(title, title, pageable);
    }

}
