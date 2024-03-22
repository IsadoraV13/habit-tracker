package com.isadora.habittracker.repository;

import com.isadora.habittracker.domain.Reward;
import com.isadora.habittracker.domain.Theme;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThemeRepository extends CrudRepository<Theme, Integer> {

    @Query(value = "select id, themeName from theme WHERE user_id = ?", nativeQuery = true)
    List<Theme> findByUserId(int userId);
}
