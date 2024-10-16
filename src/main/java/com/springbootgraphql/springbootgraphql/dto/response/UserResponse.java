package com.springbootgraphql.springbootgraphql.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;


@Data
@AllArgsConstructor
public class UserResponse {
    private Integer id;
    private String name;
    private String age;
    private String emailAddress;
    private LocalDate dob;
    private String city;
}
