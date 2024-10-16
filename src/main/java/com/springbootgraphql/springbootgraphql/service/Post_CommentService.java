package com.springbootgraphql.springbootgraphql.service;

import com.springbootgraphql.springbootgraphql.model.Post_Like;
import com.springbootgraphql.springbootgraphql.model.Post_comment;

public interface Post_CommentService {
    Post_comment comment(Integer postId, Integer userId, String comment);
}
