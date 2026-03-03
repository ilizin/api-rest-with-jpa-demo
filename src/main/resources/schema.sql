CREATE TABLE IF NOT EXISTS car (
    id int NOT NULL AUTO_INCREMENT,
    make varchar(255),
    model varchar(255),
    submodel varchar(255),
    first_registration_from integer,
    body_type varchar(255),
    price integer,
    mileage integer,
    fuel_type varchar(255),
    gear_box varchar(255),
    power integer
);

INSERT INTO car (make, model, submodel, first_registration_from, body_type, price, mileage, fuel_type, gear_box, power) VALUES ('Lamborghini', 'Miura', null, 1970, 'COUPE', 2700000, 48000, 'GASOLINE', 'MANUAL', 380);
INSERT INTO car (make, model, submodel, first_registration_from, body_type, price, mileage, fuel_type, gear_box, power) VALUES ('Ferrari', 'Testarossa', null, 1984, 'COUPE', 250000, 51000, 'GASOLINE', 'MANUAL', 380);
INSERT INTO car (make, model, submodel, first_registration_from, body_type, price, mileage, fuel_type, gear_box, power) VALUES ('Citroën', 'XM', null, 1992, 'SEDAN', 13900, 75500, 'GASOLINE', 'MANUAL', 194);
INSERT INTO car (make, model, submodel, first_registration_from, body_type, price, mileage, fuel_type, gear_box, power) VALUES ('Ferrari', 'Enzo', null, 2003, 'COUPE', 4800000, 32000, 'GASOLINE', 'MANUAL', 650);
INSERT INTO car (make, model, submodel, first_registration_from, body_type, price, mileage, fuel_type, gear_box, power) VALUES ('Lamborghini', 'Countach', null, 1981, 'COUPE', 700000, 73000, 'GASOLINE', 'MANUAL', 455);

CREATE TABLE IF NOT EXISTS motorcycle (
    id int NOT NULL AUTO_INCREMENT,
    make varchar(255),
    model varchar(255),
    submodel varchar(255),
    first_registration_from integer,
    body_type varchar(255),
    price integer,
    mileage integer,
    fuel_type varchar(255),
    gear_box varchar(255),
    power integer
);

INSERT INTO motorcycle (make, model, submodel, first_registration_from, body_type, price, mileage, fuel_type, gear_box, power) VALUES ('Ducati', '620 Sport', null, 2004, 'SUPERSPORT', 2700, 20000 'GASOLINE', 'MANUAL', 60);