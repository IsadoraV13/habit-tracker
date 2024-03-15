INSERT INTO reward (id, reward_name)
VALUES
    (1, 'L1'), -- need to add a Set<Habit> here
    (2, 'L2'); -- in reality this would only be saved when user accomplishes a habit

INSERT INTO habit (id, habit_name, user_id, theme_id, difficulty_points)
VALUES
    (1, '3 x 3 push-ups', 1, 1, 1),
    (2, '1 x 20 of something difficult', 1, 1, 1),
    (3, 'code for 2h', 1, 2, 1);

INSERT INTO theme (theme_id, theme_name)
VALUES
    (1, 'bada$$ fitness'),
    (2, 'learning to code');

INSERT INTO habit_user (id, username, is_active)
VALUES
    (1, 'user1', 1),
    (2, 'user2', 1),
    (3, 'user3', 0);