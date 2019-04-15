package com.xmgl.blog.service;

import com.xmgl.blog.entity.Article;
import com.xmgl.blog.model.ArticleModel;
import com.xmgl.blog.util.Result;
import com.xmgl.blog.util.ServerResponse;

import java.util.List;

/**
 * @author 郭秦平
 * @data: 2019/04/15
 **/
public interface ArticleService {

    /**
     * 文章列表
     * @param title
     * @param page
     * @param limit
     * @return
     */
    Result<List<ArticleModel>> selectArticleList(String title, int page, int limit);

    /**
     * 删除文章
     * @param articles
     * @return
     */
    ServerResponse deleteArticleById(List<ArticleModel> articles);

    /**
     * 插入文章
     * @param article
     * @return
     */
    ServerResponse insertArticle(Article article);

    /**
     * 查找文章ById
     * @param articleId
     * @return
     */
    Article selectArticleById(Integer articleId);

    ServerResponse updateArticle(Article article);
}
