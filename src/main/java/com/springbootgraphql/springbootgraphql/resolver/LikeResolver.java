package com.springbootgraphql.springbootgraphql.resolver;

import com.springbootgraphql.springbootgraphql.model.Post_Like;
import com.springbootgraphql.springbootgraphql.service.Post_likeService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeResolver {
    @Autowired
    private Post_likeService postLikeService;

    @GraphQLMutation(name = "likePost")
    public Post_Like likePost(@GraphQLArgument(name = "postId") Integer postId, @GraphQLArgument(name = "userId") Integer userId) {
        return postLikeService.likePost(postId, userId);
    }
}
