package com.springbootgraphql.springbootgraphql.repository;

import com.springbootgraphql.springbootgraphql.model.Post_comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Post_CommentRepository extends JpaRepository<Post_comment ,Integer> {

    List<Post_comment> findByPostId(Integer postId);
}
