-- DROP TABLE IF EXISTS race;

CREATE TABLE race (
                        id INT AUTO_INCREMENT  PRIMARY KEY,
                        race_name VARCHAR(250) NOT NULL,
                        place VARCHAR(250),
                        country VARCHAR(250)
);

INSERT INTO race (id, race_name, place, country) VALUES (100, 'mountain_race', 'Cape town', 'South Africa');
INSERT INTO race (id, race_name,place, country) VALUES (101, 'mud_race', 'Johannesburg', 'South Africa');
INSERT INTO race (id, race_name, place, country) VALUES (102, 'city_race', 'Durban', 'South Africa');
