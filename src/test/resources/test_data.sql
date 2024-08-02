INSERT INTO reward (reward_name)
VALUES
    ('L1'), -- default
    ('L2'), -- when a habit is accomplished the first time
    ('L3'), -- when a habit is accomplished subsequent times but with no streak
    ('L4'); -- when a habit is accomplished subsequent times but with a streak

INSERT INTO habit_user (username, score, is_active)
VALUES
    ('activeTestUser1', 0, 1),
    ('activeTestUser2', 0, 1),
    ('inactiveTestUser3', 0, 0);

INSERT INTO habit (habit_name, user_id, reward_id, theme_id, difficulty_points, counter)
VALUES
    ('habit1', 1, 1, 1, 1, 0),
--    (2, '1 x 20 of something difficult', 1, 1, 1, 1, 0),
    ('habit3', 1, 1, 2, 1, 0);

INSERT INTO theme (theme_name, user_id)
VALUES
    ('theme1', 1),
    ('theme2', 2);