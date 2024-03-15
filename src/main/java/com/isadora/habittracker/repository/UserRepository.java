package com.isadora.habittracker.repository;

import com.isadora.habittracker.domain.User;
import com.isadora.habittracker.domain.UserResponse;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "select id, username, is_active from habit_user WHERE is_active = true", nativeQuery = true)
    List<User> findAllActiveUsers();
}
