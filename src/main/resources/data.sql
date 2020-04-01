DROP TABLE IF EXISTS users;
 
CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  bonus_points INT DEFAULT NULL
);
 
INSERT INTO users (first_name, last_name, bonus_points) VALUES
  ('Aaron', 'Ramsey', 500),
  ('Granit', 'Xhaka', 5000),
  ('Dani', 'Ceballos', 50);
  
  
DROP TABLE IF EXISTS room;
 
CREATE TABLE room (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  status VARCHAR(250) DEFAULT NULL,
  price DOUBLE NOT NULL,
  user_id INT DEFAULT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id)
);
 
INSERT INTO room (status, price) VALUES
  ('OPEN', 500),
  ('OPEN', 5000),
  ('OPEN', 50);
  