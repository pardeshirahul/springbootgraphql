package com.springbootgraphql.springbootgraphql.service.impl;

import com.springbootgraphql.springbootgraphql.model.Post;
import com.springbootgraphql.springbootgraphql.model.Post_Like;
import com.springbootgraphql.springbootgraphql.model.User;
import com.springbootgraphql.springbootgraphql.repository.PostRepository;
import com.springbootgraphql.springbootgraphql.repository.Post_LikeRepository;
import com.springbootgraphql.springbootgraphql.repository.UserRepository;
import com.springbootgraphql.springbootgraphql.service.Post_likeService;
import com.springbootgraphql.springbootgraphql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Service
public class Post_LikeServiceImpl implements Post_likeService {

    @Autowired
    private Post_LikeRepository postLikeRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Override
    public Post_Like likePost(Integer postId, Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Post>post = postRepository.findById(postId);
        if(ObjectUtils.isEmpty(post)){
            throw new RuntimeException("Post Not Found");
        }
        Post_Like postLike= Post_Like.builder().post(post.get())
                .user(user.get())
                .build();
        return postLikeRepository.save(postLike);
    }
}
