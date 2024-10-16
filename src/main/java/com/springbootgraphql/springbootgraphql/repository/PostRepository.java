package com.springbootgraphql.springbootgraphql.repository;

import com.springbootgraphql.springbootgraphql.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
}
