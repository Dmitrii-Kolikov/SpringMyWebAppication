package com.kolikov.web.application.spring_web_application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {
    private Integer id;
    private String name;
    private String login;
    private String email;
}
