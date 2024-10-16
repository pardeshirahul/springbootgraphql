package com.springbootgraphql.springbootgraphql.service;

import com.springbootgraphql.springbootgraphql.dto.response.PostResponse;
import com.springbootgraphql.springbootgraphql.model.Post;
import com.springbootgraphql.springbootgraphql.model.User;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Post createUser(Post post);

    Optional<Post> getByPostId(Integer id);

    List<Post> getAllPost();


}
