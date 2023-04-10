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
VALUES (nextval('hibernate_sequence'),'Baza', 'Kuiv', 'car market with best cars', 5.0);
INSERT into company (id ,name, address, about, rating)
VALUES (nextval('hibernate_sequence'),'GoodAuto', 'Sumy', 'car market with best cars', 4.4);
INSERT into company (id ,name, address, about, rating)
VALUES (nextval('hibernate_sequence'),'SuperCars', 'Odesa', 'car market with best cars', 3.8);
INSERT into company (id ,name, address, about, rating)
VALUES (nextval('hibernate_sequence'),'copart', 'Kharkiv', 'car market with best cars', 4.0);

INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating)
VALUES (nextval('hibernate_sequence'),'Audi', 'crossover', 'Q5', 2016, 160, 18500, 'SEL', 1, 'WAG concern', 5.0);
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating)
VALUES (nextval('hibernate_sequence'),'BMW', 'crossover', 'X5', 2015, 300, 20500, 'Performance', 2, 'trash', 4.0);
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating)
VALUES (nextval('hibernate_sequence'),'Mercedes', 'sedan', 's63', 2017, 235, 32999, 'S', 3, 'Business Taxi', 4.4);
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating)
VALUES (nextval('hibernate_sequence'),'Renault', 'sedan', 'Megane2', 2008, 155, 6100, 'extreme', 4, 'Meno Regan', 5.0);
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating)
VALUES (nextval('hibernate_sequence'),'Skoda', 'sedan', 'rapid', 2013, 25, 10000, 'stock', 1, 'WAG concern', 5.0);
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating)
VALUES (nextval('hibernate_sequence'),'Opel', 'sedan', 'astra', 2005, 258, 4000, 'stock', 2, 'trash', 5.0);
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating)
VALUES (nextval('hibernate_sequence'),'Peugeot', 'hatchback', '308', 2021, 15, 26000, 'SE', 3, 'French tiger', 5.0);
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating)
VALUES (nextval('hibernate_sequence'),'Nissan', 'crossover', 'X-Trail', 2018, 85, 22546, 'SEL', 4, 'best', 5.0);
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating)
VALUES (nextval('hibernate_sequence'),'Volkswagen', 'crossover', 'Tuareg', 2016, 160, 36654, 'S', 1, 'WAG concern', 5.0);
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating)
VALUES (nextval('hibernate_sequence'),'Seat', 'hatchback', 'LEON', 2019, 58, 26000, 'S', 2, 'WAG concern', 5.0);
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating)
VALUES (nextval('hibernate_sequence'),'Volvo', 'crossover', 'Q8', 2016, 160, 18500, 'SL', 4, 'WAG concern', 5.0);
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating)
VALUES (nextval('hibernate_sequence'),'Honda', 'crossover', 'HCR', 2016, 160, 18500, 'SEL', 4, 'WAG concern', 5.0);

