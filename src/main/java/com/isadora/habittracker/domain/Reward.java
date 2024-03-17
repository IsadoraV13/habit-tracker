package com.isadora.habittracker.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="reward")
public class Reward {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="reward_id") //ToDo how do I get this to also be called "id"?
    private int id;
    private String rewardName;
    @OneToMany(mappedBy="reward")
    @Column(name="habits")
    private Set<Habit> habits; //a reward is not user input and many habits can be linked to the same reward level

    public Reward() {

    }

    public int getId() {
        return id;
    }


    public String getRewardName() {
        return rewardName;
    }

    public Set<Habit> getHabits() {
        return habits;
    }

}
