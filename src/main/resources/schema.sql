CREATE TABLE IF NOT EXISTS car (
    id int NOT NULL AUTO_INCREMENT,
    make varchar(255),
    model varchar(255),
    first_registration_from integer,
    body_type varchar(255),
    price integer,
    mileage integer,
    fuel_type varchar(255),
    gear_box varchar(255),
    power integer
);

CREATE TABLE IF NOT EXISTS motorcycle (
    id int NOT NULL AUTO_INCREMENT,
    make varchar(255),
    model varchar(255),
    first_registration_from integer,
    body_type varchar(255),
    price integer,
    mileage integer,
    fuel_type varchar(255),
    gear_box varchar(255),
    power integer
);

INSERT INTO car VALUES (1, 'Lamborghini', 'Miura', 1970, 'COUPE', 2700000, 48000, 'GASOLINE', 'MANUAL', 380);
INSERT INTO car VALUES (2, 'Ferrari', 'Testarossa', 1984, 'COUPE', 250000, 51000, 'GASOLINE', 'MANUAL', 380);
INSERT INTO car VALUES (3, 'Citroën', 'XM', 1992, 'SEDAN', 13900, 75500, 'GASOLINE', 'MANUAL', 194);
INSERT INTO car VALUES (4, 'Ferrari', 'Enzo', 2003, 'COUPE', 4800000, 32000, 'GASOLINE', 'MANUAL', 650);
INSERT INTO car VALUES (5, 'Lamborghini', 'Countach', 1981, 'COUPE', 700000, 73000, 'GASOLINE', 'MANUAL', 455);