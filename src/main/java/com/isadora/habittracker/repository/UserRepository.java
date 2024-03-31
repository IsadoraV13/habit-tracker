package com.isadora.habittracker.repository;

import com.isadora.habittracker.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "select id, username, score, is_active from habit_user WHERE is_active = true", nativeQuery = true)
    List<User> findAllActiveUsers();

    @Query(value = "select id, username, score, is_active from habit_user WHERE is_active = false", nativeQuery = true)
    List<User> findAllInactiveUsers();

    @Modifying
    @Query(value = "update habit_user set score =?1 WHERE id = ?2", nativeQuery = true)
    void saveUserScore(int score, int userId);
}
