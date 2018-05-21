CREATE DATABASE db_carmaker;

USE db_carmaker ;

CREATE TABLE IF NOT EXISTS employee (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    address VARCHAR(45) NOT NULL,
    phone VARCHAR(45) NOT NULL,
    register VARCHAR(45) NOT NULL,
    role VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL,
    pass VARCHAR(45) NOT NULL,
    photo LONGBLOB NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX register_UNIQUE (register ASC)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS car (
    id INT NOT NULL AUTO_INCREMENT,
    model VARCHAR(45) NOT NULL,
    production_time INT NOT NULL,
    cost_price DOUBLE NOT NULL,
    sale_price DOUBLE NOT NULL,
    color VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS supplier (
    id INT NOT NULL AUTO_INCREMENT,
    lead_time INT NOT NULL,
    name VARCHAR(45) NOT NULL,
    address VARCHAR(45) NOT NULL,
    cnpj VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS feedstock (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    quantity INT NOT NULL,
    cost DOUBLE NOT NULL,
    supplier_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (supplier_id)
        REFERENCES supplier (id)
        ON DELETE CASCADE
)  ENGINE=INNODB;


CREATE TABLE IF NOT EXISTS placed_order (
    id INT NOT NULL AUTO_INCREMENT,
    protocol VARCHAR(45) NOT NULL,
    status VARCHAR(45) NOT NULL,
    expected_date DATE NOT NULL,
    feedstock_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (feedstock_id)
        REFERENCES feedstock (id)
        ON DELETE CASCADE
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS dealership (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    address VARCHAR(45) NOT NULL,
    cnpj VARCHAR(45) NOT NULL,
    type int not null,    
    PRIMARY KEY (id)    
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS shipping_company (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    address VARCHAR(45) NOT NULL,
    cnpj VARCHAR(45) NOT NULL,
    amount INT NOT NULL,    
    fleet INT NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS recieved_order (
    id INT NOT NULL AUTO_INCREMENT,
    protocol VARCHAR(45) NOT NULL,
    status VARCHAR(45) NOT NULL,
    expected_date DATE NOT NULL,
    car_id INT NOT NULL,
    dealership_id INT NOT NULL,
    shipping_company_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (car_id)
        REFERENCES car (id)
        ON DELETE CASCADE,
    FOREIGN KEY (dealership_id)
        REFERENCES dealership (id)
        ON DELETE CASCADE,
    FOREIGN KEY (shipping_company_id)
        REFERENCES shipping_company (id)
        ON DELETE CASCADE
)  ENGINE=INNODB;

insert INTO employee(name, address, phone, register, role, email, pass) 
	value('rafael', 'a', '1', '123', 1, 'rafael@', '123');
    
insert INTO employee(name, address, phone, register, role, email, pass) 
	value('felipe', 'b', '2', '345', 0, 'felipe@', '123');
    
INSERT INTO car (model, production_time, cost_price, sale_price, color)
	values('Fiat UNO', 12, 2000.00, 5000.00, 'Black');
    
SELECT 
    *
FROM
    employee;
