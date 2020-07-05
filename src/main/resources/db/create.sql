SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS heroes (
id int PRIMARY KEY auto_increment,
name VARCHAR,
nickname VARCHAR,
age int,
power VARCHAR,
weakness VARCHAR
);