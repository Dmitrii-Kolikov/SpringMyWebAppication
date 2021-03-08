package com.kolikov.web.application.spring_web_application.service;

import com.kolikov.web.application.spring_web_application.dto.UsersDto;
import com.kolikov.web.application.spring_web_application.exception.ValidationException;
import com.kolikov.web.application.spring_web_application.repository.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.kolikov.web.application.spring_web_application.prototype.UsersPrototype.aUsers;
import static com.kolikov.web.application.spring_web_application.prototype.UsersPrototype.aUsersDTO;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserServiceImplTest {

    private UsersRepository usersRepository;
    private UsersConverter usersConverter;
    private UserService userService;

    @BeforeEach
    void setUp() {
        usersRepository = mock(UsersRepository.class);
        usersConverter = new UsersConverter();
        userService = new UserServiceImpl(usersRepository, usersConverter);

    }

    @Test
    void saveUser() throws ValidationException {
        when(usersRepository.save(any())).thenReturn(aUsers());
        UsersDto createdUser = userService.saveUser(aUsersDTO());
        assertThat(createdUser).isNotNull();
        assertThat(createdUser.getName()).isEqualTo(aUsersDTO().getName());
    }

    @Test
    void saveThrowsValidationExceptionWhenLoginIsNull() {
        UsersDto userDTO  = aUsersDTO();
        userDTO.setLogin("");
        assertThrows(ValidationException.class,
                () -> userService.saveUser(userDTO),
                "Login is Empty");
    }

    @Test
    void delete() {
    }

    @Test
    void findByLogin() {
        when(usersRepository.findByLogin(eq("test_login"))).thenReturn(aUsers());
        UsersDto foundUser = userService.findByLogin("test_login");
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getLogin()).isEqualTo("test_login");
    }

    @Test
    void findAll() {
    }
}