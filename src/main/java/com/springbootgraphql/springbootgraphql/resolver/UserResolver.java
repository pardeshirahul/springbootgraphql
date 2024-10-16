package com.springbootgraphql.springbootgraphql.resolver;

import com.springbootgraphql.springbootgraphql.dto.request.UserRequest;
import com.springbootgraphql.springbootgraphql.dto.response.PostResponse;
import com.springbootgraphql.springbootgraphql.model.User;
import com.springbootgraphql.springbootgraphql.service.UserService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserResolver {
    @Autowired
    private UserService userService;

    @GraphQLMutation(name = "createUser", description = "Create a new user")
    public User createUser(@GraphQLArgument(name = "newUser") UserRequest userRequest) {
        User user = new User();
        BeanUtils.copyProperties(userRequest, user);
        return userService.createUser(user);
    }

    @GraphQLQuery(name = "getUser", description = "Get user by ID")
    public Optional<User> getUser(@GraphQLArgument(name = "id") Integer id) {
        return userService.getUserById(id);
    }
//    @GraphQLQuery(name = "getUserById", description = "Get Post by ID")
//    public List<PostResponse> getPostById(@GraphQLArgument(name = "id") Integer id) {
//        return userService.getFullPostById(id);
//    }

}
