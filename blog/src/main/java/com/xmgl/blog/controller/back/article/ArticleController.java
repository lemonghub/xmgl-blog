package com.xmgl.blog.controller.back.article;

import com.xmgl.blog.entity.Article;
import com.xmgl.blog.model.ArticleModel;
import com.xmgl.blog.service.ArticleService;
import com.xmgl.blog.util.ObjectMapperUtil;
import com.xmgl.blog.util.Result;
import com.xmgl.blog.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 郭秦平
 * @data: 2019/04/15
 **/

@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("list")
    @ResponseBody
    private Result<List<ArticleModel>> getArticleList(String title, Integer page, Integer limit){
        return articleService.selectArticleList(title, page, limit);
    }

    @PostMapping("delete")
    @ResponseBody
    private ServerResponse deleteArticle(@RequestBody Map<String,Object> map){
        System.out.println(11);
        try {
            String json = ObjectMapperUtil.objectToString(map.get("article"));
            System.out.println(json);
            List<ArticleModel> articles = ObjectMapperUtil.convertList(json,ArticleModel.class);
            articleService.deleteArticleById(articles);
        }catch (Exception e){
            e.printStackTrace();
            return ServerResponse.createByFailure(e.getMessage());
        }
        return ServerResponse.createBySuccess();
    }

    @PostMapping("add")
    @ResponseBody
    private ServerResponse addArticle(@RequestBody Map<String,Object> map){
        try{
            String json = ObjectMapperUtil.objectToString(map.get("article"));
            Article article = ObjectMapperUtil.convertObj(json,Article.class);
            article.setCreateAt(new Date());
            articleService.insertArticle(article);
        }catch (Exception e){
            e.printStackTrace();
            return ServerResponse.createByFailure(e.getMessage());
        }
        return ServerResponse.createBySuccess();
    }
}
