package com.xmgl.blog.dao;

import com.xmgl.blog.entity.ArticleTag;

public interface ArticleTagMapper {
    int insert(ArticleTag record);

    int insertSelective(ArticleTag record);
}