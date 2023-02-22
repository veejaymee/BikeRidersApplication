-- DROP TABLE IF EXISTS result;

CREATE TABLE result (
                      id INT AUTO_INCREMENT  PRIMARY KEY,
                      riderid INT NOT NULL,
                      raceid INT NOT NULL,
                      rank INT NOT NULL

);

INSERT INTO result (id, riderid, raceid, rank) VALUES (1, 1, 100, 2);
INSERT INTO result (id, riderid, raceid, rank) VALUES (2, 3, 100, 1);
INSERT INTO result (id, riderid, raceid, rank) VALUES (3, 4, 100, 3);
INSERT INTO result (id, riderid, raceid, rank) VALUES (4, 5, 100, 4);
INSERT INTO result (id, riderid, raceid, rank) VALUES (5, 8, 100, 5);

INSERT INTO result (id, riderid, raceid, rank) VALUES (6, 10, 101, 1);
INSERT INTO result (id, riderid, raceid, rank) VALUES (7, 3, 101, 2);
INSERT INTO result (id, riderid, raceid, rank) VALUES (8, 6, 101, 3);
INSERT INTO result (id, riderid, raceid, rank) VALUES (9, 1, 101, 4);
INSERT INTO result (id, riderid, raceid, rank) VALUES (10, 4, 101, 5);

INSERT INTO result (id, riderid, raceid, rank) VALUES (11, 5, 102, 1);
INSERT INTO result (id, riderid, raceid, rank) VALUES (12, 7, 102, 2);
INSERT INTO result (id, riderid, raceid, rank) VALUES (13, 4, 102, 3);
INSERT INTO result (id, riderid, raceid, rank) VALUES (14, 2, 102, 4);
INSERT INTO result (id, riderid, raceid, rank) VALUES (15, 9, 102, 5);
