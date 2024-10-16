package com.springbootgraphql.springbootgraphql.service;

import com.springbootgraphql.springbootgraphql.model.Post_Like;

public interface Post_likeService{

    Post_Like likePost(Integer postId, Integer userId);
}
