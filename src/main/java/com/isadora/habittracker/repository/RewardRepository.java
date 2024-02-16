package com.isadora.habittracker.repository;

import com.isadora.habittracker.domain.Reward;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardRepository extends CrudRepository<Reward, Integer> {

}
