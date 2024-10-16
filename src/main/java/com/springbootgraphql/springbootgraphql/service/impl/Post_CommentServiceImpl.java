package com.springbootgraphql.springbootgraphql.service.impl;

import com.springbootgraphql.springbootgraphql.model.Post;
import com.springbootgraphql.springbootgraphql.model.Post_Like;
import com.springbootgraphql.springbootgraphql.model.Post_comment;
import com.springbootgraphql.springbootgraphql.model.User;
import com.springbootgraphql.springbootgraphql.repository.PostRepository;
import com.springbootgraphql.springbootgraphql.repository.Post_CommentRepository;
import com.springbootgraphql.springbootgraphql.repository.UserRepository;
import com.springbootgraphql.springbootgraphql.service.Post_CommentService;
import com.springbootgraphql.springbootgraphql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class Post_CommentServiceImpl implements Post_CommentService {
    @Autowired
    private Post_CommentRepository postCommentRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Override
    public Post_comment comment(Integer postId, Integer userId, String comment) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Post> post = postRepository.findById(postId);
        if (ObjectUtils.isEmpty(post)) {
            throw new RuntimeException("Post Not Found");
        }
        Post_comment postComment = Post_comment.builder()
                .post(post.get()).
                comments(comment).createdAt(LocalDateTime.now()).
                user(user.get()).build();
        postCommentRepository.save(postComment);
        return postComment;
    }
}
