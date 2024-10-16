package com.springbootgraphql.springbootgraphql.controller;

import com.springbootgraphql.springbootgraphql.resolver.CommentResolver;
import com.springbootgraphql.springbootgraphql.resolver.LikeResolver;
import com.springbootgraphql.springbootgraphql.resolver.PostResolver;
import com.springbootgraphql.springbootgraphql.resolver.UserResolver;
import com.springbootgraphql.springbootgraphql.service.impl.UserServiceImpl;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.GraphQLException;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Service
@Configuration
public class    GraphQLController {

    private final GraphQL graphQL;

    public GraphQLController(UserResolver userResolver, PostResolver postResolver, LikeResolver likeResolver, CommentResolver commentResolver) {
        GraphQLSchema schema = new GraphQLSchemaGenerator()
                .withOperationsFromSingleton(userResolver)
                .withOperationsFromSingleton(postResolver)
                .withOperationsFromSingleton(likeResolver)
                .withOperationsFromSingleton(commentResolver)
                .generate();
        this.graphQL = GraphQL.newGraphQL(schema).build();
    }

    @PostMapping(value = "/graphql")
    public Map<String, Object> execute(@RequestBody Map<String, String> request, HttpServletRequest raw)
            throws GraphQLException {
        ExecutionResult result = graphQL.execute(request.get("query"));
        Map<String, Object> response = new HashMap<>();
        response.put("data", result.getData());
        response.put("errors", result.getErrors());
        return response;
    }
}
