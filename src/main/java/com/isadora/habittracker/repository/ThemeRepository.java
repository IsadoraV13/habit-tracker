package com.isadora.habittracker.repository;

import com.isadora.habittracker.domain.Reward;
import com.isadora.habittracker.domain.Theme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends CrudRepository<Theme, Integer> {
}
