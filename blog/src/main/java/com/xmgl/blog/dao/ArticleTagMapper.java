package com.xmgl.blog.dao;

import com.xmgl.blog.entity.ArticleTag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ArticleTagMapper {
    int insert(ArticleTag record);

    int insertSelective(ArticleTag record);
}