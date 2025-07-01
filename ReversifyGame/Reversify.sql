-- Reversify SQL Logging Table (Optional)
CREATE TABLE game_logs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    player_name VARCHAR(100),
    move_number INT,
    pos1 VARCHAR(10),
    pos2 VARCHAR(10),
    is_match BOOLEAN,
    move_time FLOAT,
    total_time FLOAT
);