package com.kolikov.web.application.spring_web_application.repository;

import com.kolikov.web.application.spring_web_application.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByLogin(String login);
}
