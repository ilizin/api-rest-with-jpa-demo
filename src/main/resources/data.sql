CREATE TABLE advertisement (
    id int NOT NULL AUTO_INCREMENT,
    title varchar(255),
    city varchar(255),
    country varchar(255),
    address varchar(255),
    price bigint,
    description varchar(255)
);

CREATE TABLE advertiser (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255)
);

--INSERT INTO property (title, city, country, address, price, description) VALUES
  --('test_title1', 'test_city1', 'test_country1', 'test_address1', 'test_price1', 'test_description1'),
  --('test_title2', 'test_city2', 'test_country2', 'test_address2', 'test_price2', 'test_description2');
