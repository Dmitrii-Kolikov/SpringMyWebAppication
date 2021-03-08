package com.kolikov.web.application.spring_web_application.repository;

import com.kolikov.web.application.spring_web_application.entity.Users;
import com.kolikov.web.application.spring_web_application.prototype.UsersPrototype;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.kolikov.web.application.spring_web_application.prototype.UsersPrototype.aUsers;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class UsersRepositoryTest {

    @Autowired
    UsersRepository usersRepository;

    @Test
    void findByLogin() {
        usersRepository.save(aUsers());
        Users foundUser = usersRepository.findByLogin(aUsers().getLogin());
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getName()).isEqualTo(aUsers().getName());
    }
}