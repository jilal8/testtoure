DROP TABLE rendezvous IF EXISTS
CREATE TABLE IF NOT EXISTS rendezvous (id INT IDENTITY PRIMARY KEY, duree INT, lieu VARCHAR(100), Type VARCHAR(255));