package com.springbootgraphql.springbootgraphql.dto.response;

import com.springbootgraphql.springbootgraphql.model.Post_comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class PostREs {
    private Integer id;
    private String content;
    private String description;
    private Integer createdBy;
    private LocalDateTime createdTime;
    private List<Post_comment>comments;
}
