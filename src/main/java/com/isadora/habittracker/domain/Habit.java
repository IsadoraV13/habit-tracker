package com.isadora.habittracker.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "habit")
public class Habit {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(columnDefinition = "BIGINT GENERATED BY DEFAULT AS IDENTITY DEFAULT ON NULL PRIMARY KEY")
    private int id;
    private String habitName; // user defined ToDo: later add a field 'habit details'
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name="reward_id", nullable = false)
    private Reward reward;
    private int themeId;
    private int difficultyPoints; //ToDo translate this from an Enum selected by the user (Hard, Medium, Easy)
    private String streakFrequency; // iteration1: daily, weekly //ToDo: iteration2: x times a day or week
    private int counter;
//    @CreatedDate
    @CreationTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = false, updatable = false)
    private Instant created;
    @UpdateTimestamp
    @Column(insertable = false)
    private Instant lastModified;

    //ToDo need a way to determine streaks

    // when user clicks a button to confirm they have performed a habit:
        // reward.save()
        // create a streak of 0 (for first time)
        // then create rules (where?) around how often the habit must/can be performed to determine if a streak is achieved

    public Habit() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHabitName() {
        return habitName;
    }

    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }

    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    public int getDifficultyPoints() {
        return difficultyPoints;
    }

    public void setDifficultyPoints(int difficultyPoints) {
        this.difficultyPoints = difficultyPoints;
    }

    public String getStreakFrequency() {
        return streakFrequency;
    }

    public void setStreakFrequency(String streakFrequency) {
        this.streakFrequency = streakFrequency;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Instant getCreated() {
        return created;
    }

    public Instant getLastModified() {
        return lastModified;
    }

    @Override
    public String toString() {
        return "Habit{" +
                "id=" + id +
                ", habitName='" + habitName + '\'' +
                ", user=" + user +
                ", reward=" + reward +
                ", themeId=" + themeId +
                ", difficultyPoints=" + difficultyPoints +
                ", streakFrequency='" + streakFrequency + '\'' +
                ", counter=" + counter +
                ", created=" + created +
                ", lastModified=" + lastModified +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habit habit = (Habit) o;
        return themeId == habit.themeId && difficultyPoints == habit.difficultyPoints && counter == habit.counter && Objects.equals(id, habit.id) && Objects.equals(habitName, habit.habitName) && Objects.equals(user, habit.user) && Objects.equals(reward, habit.reward) && Objects.equals(streakFrequency, habit.streakFrequency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, habitName, user, reward, themeId, difficultyPoints, streakFrequency, counter);
    }
}
