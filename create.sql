CREATE DATABASE herosquad;
\c herosquad
CREATE TABLE heroes (id SERIAL PRIMARY KEY, name VARCHAR, nickname VARCHAR, age INTEGER, power VARCHAR, weakness VARCHAR, squadId INTEGER);
CREATE TABLE squads (id SERIAL PRIMARY KEY, name VARCHAR, cause VARCHAR, squadSize INTEGER);
CREATE DATABASE herosquad_test WITH TEMPLATE herosquad;