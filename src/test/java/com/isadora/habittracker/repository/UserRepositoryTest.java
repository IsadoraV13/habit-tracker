package com.isadora.habittracker.repository;

import com.isadora.habittracker.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@TestPropertySource("classpath:application-test.properties")
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;


    private User activeTestUser1;
    private User activeTestUser2;
    private User inactiveTestUser3;
    private User inactiveTestUser4;

    @BeforeEach
    void setUp() {
        activeTestUser1 = new User();
        activeTestUser1.setId(1);
        activeTestUser1.setUsername("activeTestUser1");
        activeTestUser1.setActive(true);

        activeTestUser2 = new User();
        activeTestUser2.setId(2);
        activeTestUser2.setUsername("activeTestUser2");
        activeTestUser2.setActive(true);

        inactiveTestUser3 = new User();
        inactiveTestUser3.setUsername("inactiveTestUser3");
        inactiveTestUser3.setActive(false);

        inactiveTestUser4 = new User();
        inactiveTestUser4.setUsername("inactiveTestUser4");
        inactiveTestUser4.setActive(false);

    }

    @AfterEach
    void tearDown() {
//        userRepository.delete(activeTestUser2);
//        userRepository.delete(activeTestUser3);
//        userRepository.delete(inactiveTestUser4);
//        userRepository.delete(inactiveTestUser5);
    }

    @Test
    void findAllActiveUsers() {
        List<User> actualActiveUsers = userRepository.findAllActiveUsers();
        List<User> expectedActiveUsers = Arrays.asList(activeTestUser1, activeTestUser2);

        System.out.println(actualActiveUsers);
        System.out.println(expectedActiveUsers);

        assertThat(actualActiveUsers).isEqualTo(expectedActiveUsers);
//        assertThat(actualActiveUsers.equals(expectedActiveUsers)).isTrue();
    }

    @Test
    void findAllInactiveUsers() {
        List<User> actualInactiveUsers = userRepository.findAllActiveUsers();
        List<User> expectedInactiveUsers = List.of(new User[]{inactiveTestUser3, inactiveTestUser4});

        assertThat(actualInactiveUsers).isEqualTo(expectedInactiveUsers);
    }

    @Test
    void saveUserScore() {
    }
}