package com.xmgl.blog.service.impl;

import com.xmgl.blog.dao.ArticleMapper;
import com.xmgl.blog.entity.Article;
import com.xmgl.blog.model.ArticleModel;
import com.xmgl.blog.service.ArticleService;
import com.xmgl.blog.util.PageCalculator;
import com.xmgl.blog.util.Result;
import com.xmgl.blog.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 郭秦平
 * @data: 2019/04/15
 **/
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Result<List<ArticleModel>> selectArticleList(String title, int page, int limit) {
        page = PageCalculator.checkPage(page);
        limit = PageCalculator.checkLimit(limit);
        int start = PageCalculator.calculateStart(page, limit);
        List<ArticleModel> customers = articleMapper.selectArticleByPager(title, start, limit);
        int count = articleMapper.selectArticleListCount(title);
        return Result.createSuccessResult(count, customers);
    }

    @Override
    public ServerResponse deleteArticleById(List<ArticleModel> articles) {
        articleMapper.deleteArticleById(articles);
        return ServerResponse.createBySuccess();
    }

    @Override
    public ServerResponse insertArticle(Article article) {
        articleMapper.insertSelective(article);
        return ServerResponse.createBySuccess();
    }
}
