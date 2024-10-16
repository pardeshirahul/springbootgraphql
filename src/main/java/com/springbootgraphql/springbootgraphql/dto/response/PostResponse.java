package com.springbootgraphql.springbootgraphql.dto.response;

import com.springbootgraphql.springbootgraphql.model.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostResponse {
    private Integer UserId;

    private Integer countLike;
    private Integer countComment;
   private List<PostREs>posts;
    private String name;
    private String age;
    private String emailAddress;
    private LocalDate dob;
    private String city;

}
