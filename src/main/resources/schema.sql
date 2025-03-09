CREATE TABLE IF NOT EXISTS advertisement(
    id int NOT NULL AUTO_INCREMENT,
    title varchar(255),
    city varchar(255),
    country varchar(255),
    address varchar(255),
    price bigint,
    description varchar(255)
);

CREATE TABLE IF NOT EXISTS advertiser(
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255)
);
