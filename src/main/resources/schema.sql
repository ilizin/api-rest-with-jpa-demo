CREATE TABLE IF NOT EXISTS vehicle (
    id int NOT NULL AUTO_INCREMENT,
    vehicle_type varchar(255),
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

INSERT INTO vehicle (vehicle_type, make, model, submodel, first_registration_from, body_type, price, mileage, fuel_type, gear_box, power) VALUES ('CAR', 'Lamborghini', 'Miura', null, 1970, 'COUPE', 2700000, 48000, 'GASOLINE', 'MANUAL', 380);
INSERT INTO vehicle (vehicle_type, make, model, submodel, first_registration_from, body_type, price, mileage, fuel_type, gear_box, power) VALUES ('CAR', 'Ferrari', 'Testarossa', null, 1984, 'COUPE', 250000, 51000, 'GASOLINE', 'MANUAL', 380);
INSERT INTO vehicle (vehicle_type, make, model, submodel, first_registration_from, body_type, price, mileage, fuel_type, gear_box, power) VALUES ('CAR', 'Citroën', 'XM', null, 1992, 'SEDAN', 13900, 75500, 'GASOLINE', 'MANUAL', 194);
INSERT INTO vehicle (vehicle_type, make, model, submodel, first_registration_from, body_type, price, mileage, fuel_type, gear_box, power) VALUES ('CAR', 'Ferrari', 'Enzo', null, 2003, 'COUPE', 4800000, 32000, 'GASOLINE', 'MANUAL', 650);
INSERT INTO vehicle (vehicle_type, make, model, submodel, first_registration_from, body_type, price, mileage, fuel_type, gear_box, power) VALUES ('CAR', 'Lamborghini', 'Countach', null, 1981, 'COUPE', 700000, 73000, 'GASOLINE', 'MANUAL', 455);

INSERT INTO vehicle (vehicle_type, make, model, submodel, first_registration_from, body_type, price, mileage, fuel_type, gear_box, power) VALUES ('MOTORCYCLE', 'Ducati', '620 Sport', null, 2004, 'SUPERSPORT', 2700, 20000, 'GASOLINE', 'MANUAL', 60);
INSERT INTO vehicle (vehicle_type, make, model, submodel, first_registration_from, body_type, price, mileage, fuel_type, gear_box, power) VALUES ('MOTORCYCLE', 'Ducati', 'Streetfighter', 'V4S', 2021, 'SUPERSPORT', 20000, 15000, 'GASOLINE', 'MANUAL', 212);
INSERT INTO vehicle (vehicle_type, make, model, submodel, first_registration_from, body_type, price, mileage, fuel_type, gear_box, power) VALUES ('MOTORCYCLE', 'Kawasaki', 'Ninja', '500 SE', 2024, 'SUPERSPORT', 7000, 17320, 'GASOLINE', 'MANUAL', 48);
INSERT INTO vehicle (vehicle_type, make, model, submodel, first_registration_from, body_type, price, mileage, fuel_type, gear_box, power) VALUES ('MOTORCYCLE', 'Honda', 'NSR 50', null, 1990, 'SUPERSPORT', 5500, 22000, 'GASOLINE', 'MANUAL', 14);
INSERT INTO vehicle (vehicle_type, make, model, submodel, first_registration_from, body_type, price, mileage, fuel_type, gear_box, power) VALUES ('MOTORCYCLE', 'Yamaha', 'FJ 1200', null, 1989, 'SUPERSPORT', 4000, 68000, 'GASOLINE', 'MANUAL', 131);