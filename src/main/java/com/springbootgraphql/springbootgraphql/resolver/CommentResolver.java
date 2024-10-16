package com.springbootgraphql.springbootgraphql.resolver;

import com.springbootgraphql.springbootgraphql.model.Post_Like;
import com.springbootgraphql.springbootgraphql.model.Post_comment;
import com.springbootgraphql.springbootgraphql.service.Post_CommentService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentResolver {
   @Autowired
   private Post_CommentService postCommentService;

    @GraphQLMutation(name = "commentPost")
    public Post_comment commentPost(@GraphQLArgument(name = "postId") Integer postId, @GraphQLArgument(name = "userId") Integer userId, @GraphQLArgument(name = "comment") String comment) {
        return postCommentService.comment(postId, userId, comment);
    }


}
