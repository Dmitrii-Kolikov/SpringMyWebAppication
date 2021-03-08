package com.kolikov.web.application.spring_web_application.prototype;

import com.kolikov.web.application.spring_web_application.dto.UsersDto;
import com.kolikov.web.application.spring_web_application.entity.Users;

public class UsersPrototype {


    public static Users aUsers() {
        Users u = new Users();
        u.setName("test_name");
        u.setLogin("test_login");
        return u;
    }

    public static UsersDto aUsersDTO() {
        return UsersDto.builder()
                .name("test_name")
                .login("test_login")
                .build();
    }
}
