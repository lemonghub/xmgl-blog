package com.xmgl.blog.dao;

import com.xmgl.blog.entity.CommentReply;

public interface CommentReplyMapper {
    int insert(CommentReply record);

    int insertSelective(CommentReply record);
}