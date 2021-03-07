package com.kolikov.web.application.spring_web_application.service;

import com.kolikov.web.application.spring_web_application.dto.UsersDto;
import com.kolikov.web.application.spring_web_application.entity.Users;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Builder
@Component
public class UsersConverter {

    public Users fromUserDtoToUser(UsersDto usersDto) {
        Users users = new Users();
        users.setId(usersDto.getId());
        users.setName(usersDto.getName());
        users.setLogin(usersDto.getLogin());
        users.setEmail(usersDto.getEmail());
        return users;
 }


    public UsersDto fromUserToUserDto(Users users) {
        return UsersDto.builder()
                .id(users.getId())
                .name(users.getName())
                .login(users.getLogin())
                .email(users.getEmail())
                .build();
    }
}
