package com.tensquare.search.controller;

import com.tensquare.search.pojo.Article;
import com.tensquare.search.service.ArticleSearchService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: SearchController
 * @Author: lish
 * @Date: 2019/4/25 10:10
 * @Description: 文章搜索
 */
@RestController
@CrossOrigin
@RequestMapping("/search")
public class ArticleSearchController {

    @Autowired
    private ArticleSearchService articleSearchService;

    @RequestMapping(method = RequestMethod.POST)
    private Result save(Article article){
        articleSearchService.save(article);
        return  new Result(true, StatusCode.OK,"添加成功");
    }

    //按输入标题搜索标题
    @RequestMapping(value = "/search/{keywords}/{page}/{size}",method = RequestMethod.GET)
    private Result findByTitleLike(String keywords,int page,int size){
        Page<Article> articlePage = articleSearchService.findByTitleLike(keywords, page, size);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<Article>(articlePage.getTotalElements(),articlePage.getContent()));
    }
}
