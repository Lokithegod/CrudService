create sequence hibernate_sequence start 1 increment 1;

create table car
(
    id                int4 not null,
    about             varchar(255),
    equipment         varchar(255),
    mileage           int4,
    model             varchar(255),
    name              varchar(255),
    price             int4,
    rating            float8,
    type              varchar(255),
    year              varchar(255),
    company_entity_id int4,
    primary key (id)
);
create table company
(
    id      int4 not null,
    about   varchar(255),
    address varchar(255),
    name    varchar(255),
    rating  float8,
    primary key (id)
);
alter table car
    add constraint car_k foreign key (company_entity_id) references company;


INSERT into company (id ,name, address, about, rating)
VALUES (nextval('hibernate_sequence'),'Auto Bazar', 'Kuiv', 'car marcet with best cars', 5.0);
INSERT into company (id ,name, address, about, rating)
VALUES (nextval('hibernate_sequence'),'Auto Bazar', 'Sumy', 'car marcet with best cars', 4.4);
INSERT into company (id ,name, address, about, rating)
VALUES (nextval('hibernate_sequence'),'Auto Bazar', 'Odesa', 'car marcet with best cars', 3.8);
INSERT into company (id ,name, address, about, rating)
VALUES (nextval('hibernate_sequence'),'Auto Bazar', 'Kharkiv', 'car marcet with best cars', 4.0);

INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating)
VALUES (nextval('hibernate_sequence'),'Audi', 'crossover', 'Q5', 2016, 160, 18500, 'SEL', 1, 'WAG concern', 5.0);
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating)
VALUES (nextval('hibernate_sequence'),'Audi', 'crossover', 'Q7', 2016, 160, 18500, 'SE', 2, 'WAG concern', 5.0);
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating)
VALUES (nextval('hibernate_sequence'),'Audi', 'crossover', 'Q3', 2016, 160, 18500, 'S', 3, 'WAG concern', 5.0);
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating)
VALUES (nextval('hibernate_sequence'),'Audi', 'crossover', 'Q4', 2016, 160, 18500, 'SEL', 4, 'WAG concern', 5.0);
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating)
VALUES (nextval('hibernate_sequence'),'Audi', 'crossover', 'Q1', 2016, 160, 18500, 'SEL', 1, 'WAG concern', 5.0);
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating)
VALUES (nextval('hibernate_sequence'),'Audi', 'crossover', 'Q5', 2016, 160, 18500, 'SE', 2, 'WAG concern', 5.0);
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating)
VALUES (nextval('hibernate_sequence'),'Audi', 'crossover', 'Q5', 2016, 160, 18500, 'SE', 3, 'WAG concern', 5.0);
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating)
VALUES (nextval('hibernate_sequence'),'Audi', 'crossover', 'Q7', 2016, 160, 18500, 'SE', 4, 'WAG concern', 5.0);
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating)
VALUES (nextval('hibernate_sequence'),'Audi', 'crossover', 'Q5', 2016, 160, 18500, 'S', 1, 'WAG concern', 5.0);
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating)
VALUES (nextval('hibernate_sequence'),'Audi', 'crossover', 'Q8', 2016, 160, 18500, 'S', 2, 'WAG concern', 5.0);
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating)
VALUES (nextval('hibernate_sequence'),'Audi', 'crossover', 'Q8', 2016, 160, 18500, 'SL', 4, 'WAG concern', 5.0);
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating)
VALUES (nextval('hibernate_sequence'),'Audi', 'crossover', 'Q5', 2016, 160, 18500, 'SEL', 4, 'WAG concern', 5.0);

