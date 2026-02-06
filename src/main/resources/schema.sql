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