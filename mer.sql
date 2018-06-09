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
    deleted int NOT NULL DEFAULT 0, 
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
    deleted int NOT NULL DEFAULT 0, 
    PRIMARY KEY (id)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS supplier (
    id INT NOT NULL AUTO_INCREMENT,
    lead_time INT NOT NULL,
    name VARCHAR(45) NOT NULL,
    address VARCHAR(45) NOT NULL,
    cnpj VARCHAR(45) NOT NULL,
    deleted int NOT NULL DEFAULT 0, 
    PRIMARY KEY (id)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS feedstock (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    quantity INT NOT NULL,
    cost DOUBLE NOT NULL,
    deleted int NOT NULL DEFAULT 0, 
    PRIMARY KEY (id)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS feedstock_has_supplier (
	feedstock_id INT NOT NULL,
    supplier_id INT NOT NULL,
    FOREIGN KEY(feedstock_id) REFERENCES feedstock(id),
    FOREIGN KEY(supplier_id) REFERENCES supplier(id)
) ENGINE INNODB;

CREATE TABLE IF NOT EXISTS placed_order (
    id INT NOT NULL AUTO_INCREMENT,
    protocol VARCHAR(45) NOT NULL,
    delivery_status VARCHAR(45) NOT NULL,
    expected_date DATE NOT NULL,
    feedstock_id INT NOT NULL,
    deleted int NOT NULL DEFAULT 0, 
    PRIMARY KEY (id),
    FOREIGN KEY (feedstock_id)
        REFERENCES feedstock (id)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS shipping_company (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    address VARCHAR(45) NOT NULL,
    cnpj VARCHAR(45) NOT NULL,
    amount INT NOT NULL,    
    fleet INT NOT NULL,
    deleted int NOT NULL DEFAULT 0,  
    PRIMARY KEY (id)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS dealership (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    address VARCHAR(45) NOT NULL,
    cnpj VARCHAR(45) NOT NULL,
    type int not null,
    shipping_company_id INT NOT NULL,
    deleted int NOT NULL DEFAULT 0, 
    PRIMARY KEY (id),
    FOREIGN KEY(shipping_company_id) REFERENCES shipping_company (id)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS received_order (
    id INT NOT NULL AUTO_INCREMENT,
    protocol VARCHAR(45) NOT NULL,
    delivery_status VARCHAR(45) NOT NULL,
    expected_date DATE NOT NULL,
    car_id INT NOT NULL,
    dealership_id INT NOT NULL,
    deleted int NOT NULL DEFAULT 0, 
    PRIMARY KEY (id),
    FOREIGN KEY (car_id)
        REFERENCES car (id),
    FOREIGN KEY (dealership_id)
        REFERENCES dealership (id)
)  ENGINE=INNODB;

#Exemplos de funcionários
INSERT INTO employee(name, address, phone, register, role, email, pass) 
	VALUES('Rafael', 'a', '1', '123', 1, 'rafael@', '123');
    
INSERT INTO employee(name, address, phone, register, role, email, pass) 
	VALUES('Felipe', 'b', '2', '345', 0, 'felipe@', '123');
    
#Exemplos de carros
INSERT INTO car (model, production_time, cost_price, sale_price, color)
	VALUES('Fiat UNO', 12, 2000.00, 5000.00, 'Black');
    
INSERT INTO car (model, production_time, cost_price, sale_price, color)
	VALUES('Fusca', 15, 8000.00, 10000.00, 'Azul');
    
#Exemplos de fornecedores    
INSERT INTO supplier(lead_time, name, address, cnpj)
	VALUES(8, 'Fornecedor 1', 'Rua X - nº 1, Bairro A', '15615615665');
    
INSERT INTO supplier(lead_time, name, address, cnpj)
	VALUES(10, 'Fornecedor 2', 'Rua Y - nº 2, Bairro B', '454214489144');
    
INSERT INTO supplier(lead_time, name, address, cnpj)
	VALUES(12, 'Fornecedor 3', 'Rua Z - nº 3, Bairro C', '16516512020');

#Exemplos de transportadoras    
INSERT INTO shipping_company(amount, fleet, name, address, cnpj)
	VALUES(8, 10, 'Transportadora 1', 'Rua X - nº 1, Bairro A', '15615615665');
    
INSERT INTO shipping_company(amount, fleet, name, address, cnpj)
	VALUES(10, 20, 'Transportadora 2', 'Rua Y - nº 2, Bairro B', '454214489144');
    
INSERT INTO shipping_company(amount, fleet, name, address, cnpj)
	VALUES(12, 30, 'Transportadora 3', 'Rua Z - nº 3, Bairro C', '16516512020');
    
#Exemplos de concessionárias    
INSERT INTO dealership(type, name, address, cnpj, shipping_company_id)
	VALUES(0, 'Concessionária 1', 'Rua X - nº 1, Bairro A', '15615615665', 1);
    
INSERT INTO dealership(type, name, address, cnpj, shipping_company_id)
	VALUES(1, 'Concessionária 2', 'Rua Y - nº 2, Bairro B', '454214489144', 2);
    
INSERT INTO dealership(type, name, address, cnpj, shipping_company_id)
	VALUES(1, 'Concessionária 3', 'Rua Z - nº 3, Bairro C', '16516512020', 3);
    
#Exemplo de Matéria-prima
INSERT INTO feedstock(name, quantity, cost)
	VALUES('Pneu', 8000, 120);
    
#Exemplo de Matéria-prima
INSERT INTO feedstock(name, quantity, cost)
	VALUES('Parachoque', 8000, 200);    

#Exemplo de Matéria-prima
INSERT INTO feedstock(name, quantity, cost)
	VALUES('Bancos', 4000, 120);
    
SELECT 
    dealership.id AS 'd_id',
    dealership.name AS 'd_name',
    dealership.address,
    dealership.cnpj,
    dealership.type,
    shipping_company.id AS 'sc_id',
    shipping_company.name AS 'sc_name'
FROM
    dealership
        INNER JOIN
    shipping_company ON shipping_company.id = dealership.shipping_company_id
WHERE
    dealership.id = 0 AND dealership.deleted
        AND shipping_company.deleted = 0;
        
SELECT 
    received_order.id,
    received_order.protocol,
    received_order.expected_date,
    car.id AS 'car_id',
    car.model AS 'model',
    dealership.id AS 'dealership_id',
    dealership.name AS 'name'
FROM
    received_order
        INNER JOIN
    car ON car.id = received_order.car_id
        INNER JOIN
    dealership ON dealership.id = received_order.dealership_id
WHERE
    received_order.deleted = 0;
    
SELECT 
    received_order.id,
    received_order.protocol,
    received_order.expected_date
    
FROM
    received_order
WHERE
    received_order.deleted = 0;

SELECT * FROM received_order;

UPDATE received_order SET protocol='123456', expected_date='2018-06-08', delivery_status=4, car_id=1, dealership_id=1;

SELECT received_order.id, 
received_order.protocol, 
received_order.expected_date, 
car.id AS 'car_id', 
car.model AS 'model', 
dealership.id AS 'dealership_id', 
dealership.name AS 'name',shipping_company.id AS 'scomp_id', shipping_company.name AS 'scomp_name' FROM received_order INNER JOIN car ON car.id=received_order.car_id INNER JOIN dealership ON dealership.id=received_order.dealership_id INNER JOIN shipping_company ON dealership.shipping_company_id=shipping_company.id WHERE received_order.deleted=0;