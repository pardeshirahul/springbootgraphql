package com.springbootgraphql.springbootgraphql.repository;

import com.springbootgraphql.springbootgraphql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


}
