create table IF NOT EXISTS company
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name       varchar(64),
    address    varchar(255),
    about      varchar(255),
    rating     double
);


create table IF NOT EXISTS car
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name                varchar(64),
    type                varchar(64),
    model               varchar(64),
    year                date,
    mileage             INT,
    price               double,
    equipment           INT,
    company             INT,
    about               varchar(255),
    rating              double,
    FOREIGN KEY (company)  REFERENCES company(id)
);

INSERT into company (name, address, about, rating) VALUES ('Auto Bazar','Kuiv','car marcet with best cars',5.0);
INSERT into company (name, address, about, rating) VALUES ('Auto Bazar','Sumy','car marcet with best cars',4.4);
INSERT into company (name, address, about, rating) VALUES ('Auto Bazar','Odesa','car marcet with best cars',3.8);
INSERT into company (name, address, about, rating) VALUES ('Auto Bazar','Kharkiv','car marcet with best cars',4.0);

INSERT into car (name, type, model, year, mileage, price, equipment, company, about, rating) VALUES ('Audi','crossover','Q5',2016,160,18500,'SEL',1,'WAG concern',5.0);
INSERT into car (name, type, model, year, mileage, price, equipment, company, about, rating) VALUES ('Audi','crossover','Q7',2016,160,18500,'SE',2,'WAG concern',5.0);
INSERT into car (name, type, model, year, mileage, price, equipment, company, about, rating) VALUES ('Audi','crossover','Q3',2016,160,18500,'S',3,'WAG concern',5.0);
INSERT into car (name, type, model, year, mileage, price, equipment, company, about, rating) VALUES ('Audi','crossover','Q4',2016,160,18500,'SEL',4,'WAG concern',5.0);
INSERT into car (name, type, model, year, mileage, price, equipment, company, about, rating) VALUES ('Audi','crossover','Q1',2016,160,18500,'SEL',1,'WAG concern',5.0);
INSERT into car (name, type, model, year, mileage, price, equipment, company, about, rating) VALUES ('Audi','crossover','Q5',2016,160,18500,'SE',2,'WAG concern',5.0);
INSERT into car (name, type, model, year, mileage, price, equipment, company, about, rating) VALUES ('Audi','crossover','Q5',2016,160,18500,'SE',3,'WAG concern',5.0);
INSERT into car (name, type, model, year, mileage, price, equipment, company, about, rating) VALUES ('Audi','crossover','Q7',2016,160,18500,'SE',4,'WAG concern',5.0);
INSERT into car (name, type, model, year, mileage, price, equipment, company, about, rating) VALUES ('Audi','crossover','Q5',2016,160,18500,'S',1,'WAG concern',5.0);
INSERT into car (name, type, model, year, mileage, price, equipment, company, about, rating) VALUES ('Audi','crossover','Q8',2016,160,18500,'S',2,'WAG concern',5.0);
INSERT into car (name, type, model, year, mileage, price, equipment, company, about, rating) VALUES ('Audi','crossover','Q8',2016,160,18500,'SL',4,'WAG concern',5.0);
INSERT into car (name, type, model, year, mileage, price, equipment, company, about, rating) VALUES ('Audi','crossover','Q5',2016,160,18500,'SEL',4,'WAG concern',5.0);

