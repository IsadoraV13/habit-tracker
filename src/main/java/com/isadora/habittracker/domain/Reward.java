package com.isadora.habittracker.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="reward")
public class Reward {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String rewardName;

    /*
    removed as it doesn't make sense for a reward level to have every habit saved against itl; a unidirectional mapping is sufficient
     */
//    @OneToMany(mappedBy="reward")
//    @Column(name="habits")
//    private Set<Habit> habits; //a reward is not user input and many habits can be linked to the same reward level

    public Reward() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }
}
