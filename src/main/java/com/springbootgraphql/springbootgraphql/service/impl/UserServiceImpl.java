package com.springbootgraphql.springbootgraphql.service.impl;

import com.springbootgraphql.springbootgraphql.dto.response.PostREs;
import com.springbootgraphql.springbootgraphql.dto.response.PostResponse;
import com.springbootgraphql.springbootgraphql.model.Post;
import com.springbootgraphql.springbootgraphql.model.Post_comment;
import com.springbootgraphql.springbootgraphql.model.User;
import com.springbootgraphql.springbootgraphql.repository.PostRepository;
import com.springbootgraphql.springbootgraphql.repository.Post_CommentRepository;
import com.springbootgraphql.springbootgraphql.repository.Post_LikeRepository;
import com.springbootgraphql.springbootgraphql.repository.UserRepository;
import com.springbootgraphql.springbootgraphql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private Post_LikeRepository postLikeRepository;
    @Autowired
    private Post_CommentRepository postCommentRepository;


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }
//    @Override
//    public List<PostResponse> getFullPostById(Integer id) {
//        Optional<User> users = userRepository.findById(id);
//        List<PostREs> res = new ArrayList<>();
//        for(Post post : users.get().getPosts()){
//          List<Post_comment>comments =  postCommentRepository.findByPostId(post.getId());
//          comments.size();
//          res.add( PostREs.builder().id(post.getId())
//                  .comments(comments)
//                  .content(post.getContent())
//                  .createdTime(post.getCreatedTime()).
//                  description(post.getDescription()).build());
//
//        }
//
//        PostResponse.builder().UserId(users.get().getId()).posts(users.get().getPosts().stream()
//        return List.of();
//    }

}
