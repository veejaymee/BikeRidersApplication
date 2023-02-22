INSERT INTO riders (id, fisrt_name, last_name) VALUES (1, 'Vijaya', 'V');
INSERT INTO riders (id, fisrt_name, last_name) VALUES (2, 'Paul', 'p');
INSERT INTO riders (id, fisrt_name, last_name) VALUES (3, 'Andrew', 'A');
INSERT INTO riders (id, fisrt_name, last_name) VALUES (4, 'Krishna', 'K');
INSERT INTO riders (id, fisrt_name, last_name) VALUES (5, 'Json', 'J');
INSERT INTO riders (id, fisrt_name, last_name) VALUES (6, 'Abi', 'Ab');
INSERT INTO riders (id, fisrt_name, last_name) VALUES (7, 'Bjon', 'b');
INSERT INTO riders (id, fisrt_name, last_name) VALUES (8, 'Cirel', 'c');
INSERT INTO riders (id, fisrt_name, last_name) VALUES (9, 'Danny', 'D');
INSERT INTO riders (id, fisrt_name, last_name) VALUES (10, 'Elan', 'E');

INSERT INTO race (id, race_name, place, country) VALUES (100, 'mountain_race', 'Cape town', 'South Africa');
INSERT INTO race (id, race_name,place, country) VALUES (101, 'mud_race', 'Johannesburg', 'South Africa');
INSERT INTO race (id, race_name, place, country) VALUES (102, 'city_race', 'Durban', 'South Africa');

INSERT INTO result (id, riderid, raceid, rank) VALUES (1, 2, 100, 2);
INSERT INTO result (id, riderid, raceid, rank) VALUES (2, 3, 100, 1);
INSERT INTO result (id, riderid, raceid, rank) VALUES (3, 4, 100, 3);
INSERT INTO result (id, riderid, raceid, rank) VALUES (4, 5, 100, 4);
INSERT INTO result (id, riderid, raceid, rank) VALUES (5, 8, 100, 5);

INSERT INTO result (id, riderid, raceid, rank) VALUES (6, 2, 101, 1);
INSERT INTO result (id, riderid, raceid, rank) VALUES (7, 3, 101, 2);
INSERT INTO result (id, riderid, raceid, rank) VALUES (8, 6, 101, 3);
INSERT INTO result (id, riderid, raceid, rank) VALUES (9, 5, 101, 4);
INSERT INTO result (id, riderid, raceid, rank) VALUES (10, 4, 101, 5);

INSERT INTO result (id, riderid, raceid, rank) VALUES (11, 5, 102, 1);
INSERT INTO result (id, riderid, raceid, rank) VALUES (12, 7, 102, 2);
INSERT INTO result (id, riderid, raceid, rank) VALUES (13, 4, 102, 3);
INSERT INTO result (id, riderid, raceid, rank) VALUES (14, 2, 102, 4);
INSERT INTO result (id, riderid, raceid, rank) VALUES (15, 9, 102, 5);