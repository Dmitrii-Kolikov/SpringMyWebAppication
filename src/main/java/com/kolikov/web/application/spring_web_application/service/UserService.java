package com.kolikov.web.application.spring_web_application.service;


import com.kolikov.web.application.spring_web_application.dto.UsersDto;
import com.kolikov.web.application.spring_web_application.exception.ValidationException;

import java.util.List;

public interface UserService {

    UsersDto saveUser(UsersDto usersDto) throws ValidationException;

    void delete(Integer userID);

    UsersDto findByLogin(String login);

    List<UsersDto> findAll();
}
