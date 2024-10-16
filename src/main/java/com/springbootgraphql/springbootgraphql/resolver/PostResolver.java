package com.springbootgraphql.springbootgraphql.resolver;

import com.springbootgraphql.springbootgraphql.dto.request.UserRequest;
import com.springbootgraphql.springbootgraphql.dto.response.PostResponse;
import com.springbootgraphql.springbootgraphql.model.Post;
import com.springbootgraphql.springbootgraphql.model.User;
import com.springbootgraphql.springbootgraphql.service.PostService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostResolver {
    @Autowired
    private PostService postService;

    @GraphQLMutation(name = "createPost", description = "Create a new Post")
    public Post createPost(@GraphQLArgument(name = "post") Post post) {
        Post posts = new Post();
        BeanUtils.copyProperties(post, posts);
        return postService.createUser(post);
    }

    @GraphQLQuery(name = "getPost", description = "Get Post by ID")
    public Optional<Post> getPost(@GraphQLArgument(name = "id") Integer id) {
        return postService.getByPostId(id);
    }

    @GraphQLQuery(name = "getAllPost", description = "Get post")
    public List<Post> getAllPost() {
        return postService.getAllPost();
    }

}
