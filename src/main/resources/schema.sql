CREATE TABLE IF NOT EXISTS advertisement(
    id int NOT NULL AUTO_INCREMENT,
    title varchar(255),
    province varchar(255),
    municipality varchar(255),
    country varchar(255),
    address varchar(255),
    price real,
    description varchar(255),
    size integer,
    floor integer,
    total_rooms integer,
    total_flatmates integer,
    total_bathrooms integer,
    flatmates_gender varchar(255),
    flatmates_age varchar(255),
    is_lgbt_friendly boolean,
    has_lift boolean
);

CREATE TABLE IF NOT EXISTS advertiser(
    id int NOT NULL AUTO_INCREMENT,
    advertiser_type varchar(255),
    name varchar(255),
    first_surname varchar(255),
    second_surname varchar(255),
    email varchar(255),
    phone_number varchar(255)
);
