package com.springbootgraphql.springbootgraphql.service;

import com.springbootgraphql.springbootgraphql.dto.response.PostResponse;
import com.springbootgraphql.springbootgraphql.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);

    public Optional<User> getUserById(Integer id);
//    List<PostResponse> getFullPostById(Integer id);
}
