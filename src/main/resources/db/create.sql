SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS heroes (
id int PRIMARY KEY auto_increment,
name VARCHAR,
nickname VARCHAR,
age int,
power VARCHAR,
weakness VARCHAR,
squadId int
);

CREATE TABLE IF NOT EXISTS squads (
id int PRIMARY KEY auto_increment,
name VARCHAR,
cause VARCHAR,
squadSize int
);