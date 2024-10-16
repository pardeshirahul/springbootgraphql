package com.springbootgraphql.springbootgraphql.service.impl;

import com.springbootgraphql.springbootgraphql.dto.response.PostResponse;
import com.springbootgraphql.springbootgraphql.model.Post;
import com.springbootgraphql.springbootgraphql.model.User;
import com.springbootgraphql.springbootgraphql.repository.PostRepository;
import com.springbootgraphql.springbootgraphql.repository.Post_CommentRepository;
import com.springbootgraphql.springbootgraphql.repository.Post_LikeRepository;
import com.springbootgraphql.springbootgraphql.repository.UserRepository;
import com.springbootgraphql.springbootgraphql.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Post_LikeRepository postLikeRepository;
    @Autowired
    private Post_CommentRepository postCommentRepository;

    @Override
    public Post createUser(Post post) {
        Optional<User>user= userRepository.findById(post.getCreatedBy());
        if (ObjectUtils.isEmpty(user)) {
            throw  new RuntimeException("UserNotFound");
        }
        LocalDateTime time = LocalDateTime.now();
        post.setCreatedTime(time);
        post.setUser(user.get());
        return postRepository.save(post);
    }

    @Override
    public Optional<Post> getByPostId(Integer id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }


}
