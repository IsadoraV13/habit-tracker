package com.isadora.habittracker.repository;

import com.isadora.habittracker.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;


    private User activeTestUser2;
    private User activeTestUser3;
    private User inactiveTestUser4;
    private User inactiveTestUser5;

    @BeforeEach
    void setUp() {
        activeTestUser2 = new User();
        activeTestUser2.setUsername("activeTestUser2");
        activeTestUser2.setActive(true);
        entityManager.persist(activeTestUser2);


        activeTestUser3 = new User();
        activeTestUser3.setUsername("activeTestUser3");
        activeTestUser3.setActive(true);
        userRepository.save(activeTestUser3);

        inactiveTestUser4 = new User();
        inactiveTestUser4.setUsername("inactiveTestUser4");
        inactiveTestUser4.setActive(false);
        userRepository.save(inactiveTestUser4);

        inactiveTestUser5 = new User();
        inactiveTestUser5.setUsername("inactiveTestUser5");
        inactiveTestUser5.setActive(false);
        userRepository.save(inactiveTestUser5);
    }

    @AfterEach
    void tearDown() {
        userRepository.delete(activeTestUser2);
        userRepository.delete(activeTestUser3);
        userRepository.delete(inactiveTestUser4);
        userRepository.delete(inactiveTestUser5);
    }

    @Test
    void findAllActiveUsers() {
        List<User> actualActiveUsers = userRepository.findAllActiveUsers();
        List<User> expectedActiveUsers = List.of(new User[]{activeTestUser2, activeTestUser3});

        System.out.println(actualActiveUsers);
        System.out.println(expectedActiveUsers);

        assertThat(actualActiveUsers).isEqualTo(expectedActiveUsers);
    }

    @Test
    void findAllInactiveUsers() {
        List<User> actualInactiveUsers = userRepository.findAllActiveUsers();
        List<User> expectedInactiveUsers = List.of(new User[]{inactiveTestUser4, inactiveTestUser5});

        assertThat(actualInactiveUsers).isEqualTo(expectedInactiveUsers);
    }

    @Test
    void saveUserScore() {
    }
}