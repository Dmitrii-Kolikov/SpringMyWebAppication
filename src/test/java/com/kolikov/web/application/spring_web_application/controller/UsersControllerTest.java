package com.kolikov.web.application.spring_web_application.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.kolikov.web.application.spring_web_application.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static com.kolikov.web.application.spring_web_application.prototype.UsersPrototype.aUsers;
import static com.kolikov.web.application.spring_web_application.prototype.UsersPrototype.aUsersDTO;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UsersControllerTest {

    MockMvc mockMvc;
    ObjectMapper objectMapper;
    UserService userService;

    @BeforeEach
    void setUp() {
        userService = mock(UserService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new UsersController(userService)).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void saveUsers() throws Exception {
        when(userService.saveUser(any())).thenReturn(aUsersDTO());
        mockMvc.perform(post("/users/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(aUsersDTO())))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(aUsers())));
    }


    @Test
    void findAllUsers() throws Exception {
        when(userService.findAll()).thenReturn(Collections.singletonList(aUsersDTO()));
        mockMvc.perform(get("/users/findAll")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(Collections.singletonList(aUsersDTO()))))
                .andExpect(status().isOk());
    }



    @Test
    void deleteUsers() {
    }
}