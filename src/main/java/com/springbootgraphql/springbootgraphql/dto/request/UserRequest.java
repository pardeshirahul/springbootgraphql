package com.springbootgraphql.springbootgraphql.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserRequest {
    private String name;
    private String age;
    private String emailAddress;
    private LocalDate dob;
    private String city;
}
