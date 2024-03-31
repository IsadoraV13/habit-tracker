INSERT INTO reward (id, reward_name)
VALUES
    (1, 'L1'), -- default
    (2, 'L2'), -- in reality this would only be saved when a habit is accomplished the first time
    (3, 'L3'), -- in reality this would only be saved when a habit is accomplished subsequent times but with no streak
    (4, 'L4'); -- in reality this would only be saved when a habit is accomplished subsequent times but with a streak

INSERT INTO habit_user (id, username, score, is_active)
VALUES
    (1, 'user1', 0, 1),
    (2, 'user2', 0, 1),
    (3, 'user3', 0, 0);

INSERT INTO habit (id, habit_name, user_id, reward_id, theme_id, difficulty_points, counter)
VALUES
    (1, '3 x 3 push-ups', 1, 1, 1, 1, 0),
--    (2, '1 x 20 of something difficult', 1, 1, 1, 1, 0),
    (3, 'code for 2h', 1, 1, 2, 1, 0);

INSERT INTO theme (id, theme_name, user_id)
VALUES
    (1, 'bada$$ fitness', 1),
    (2, 'learning to code', 2);