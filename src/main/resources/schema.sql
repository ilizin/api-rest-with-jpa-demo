CREATE TABLE IF NOT EXISTS advertisement(
    id int NOT NULL AUTO_INCREMENT,
    title varchar(255),
    province varchar(255),
    municipality varchar(255),
    country varchar(255),
    address varchar(255),
    price real,
    description varchar(255),
    size integer
);

CREATE TABLE IF NOT EXISTS advertiser(
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255)
);
