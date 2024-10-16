package com.springbootgraphql.springbootgraphql.repository;

import com.springbootgraphql.springbootgraphql.model.Post_Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Post_LikeRepository extends JpaRepository<Post_Like,Integer> {

    @Query("SELECT COUNT(pl) FROM Post_Like pl WHERE pl.post.id = :postId")
    Integer countByPostId(Integer postId);
}
