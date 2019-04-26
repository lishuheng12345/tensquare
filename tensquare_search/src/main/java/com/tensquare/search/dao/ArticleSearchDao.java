package com.tensquare.search.dao;

import com.tensquare.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @ClassName: ArticleSearchDao
 * @Author: lish
 * @Date: 2019/4/25 9:53
 * @Description: ${description}
 */
public interface ArticleSearchDao extends ElasticsearchRepository<Article,String>{
    public Page<Article> findbyTitleOrContentLike(String title, String content, Pageable p);

}
