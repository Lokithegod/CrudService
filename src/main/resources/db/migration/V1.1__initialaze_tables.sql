create sequence hibernate_sequence start 1 increment 1;

create table car
(
    id                int4 not null,
    about             varchar(255) not null,
    equipment         varchar(255) not null,
    mileage           int4 not null,
    model             varchar(255) not null,
    name              varchar(255) not null,
    price             int4 not null,
    rating            float8 not null,
    type              varchar(255) not null,
    year              varchar(255) not null,
    vin               varchar(255) UNIQUE not null,
    company_entity_id int4,
    primary key (id)
);
create table company
(
    id      int4 not null,
    about   varchar(255) not null,
    address varchar(255) not null,
    name    varchar(255) not null,
    rating  float8 not null,
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

INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating,vin)
VALUES (nextval('hibernate_sequence'),'Audi', 'crossover', 'Q5', 2016, 160, 18500, 'SEL', 1, 'WAG concern', 5.0,'JH4DA9390MS033554');
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating,vin)
VALUES (nextval('hibernate_sequence'),'BMW', 'crossover', 'X5', 2015, 300, 20500, 'Performance', 2, 'trash', 4.0,'JH4DA3450JS001899');
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating,vin)
VALUES (nextval('hibernate_sequence'),'Mercedes', 'sedan', 's63', 2017, 235, 32999, 'S', 3, 'Business Taxi', 4.4,'JH4DB1650LS007249');
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating,vin)
VALUES (nextval('hibernate_sequence'),'Renault', 'sedan', 'Megane2', 2008, 155, 6100, 'extreme', 4, 'Meno Regan', 5.0,'1G1JC524417418958');
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating,vin)
VALUES (nextval('hibernate_sequence'),'Skoda', 'sedan', 'rapid', 2013, 25, 10000, 'stock', 1, 'WAG concern', 5.0,'JH4KA7670PC005516');
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating,vin)
VALUES (nextval('hibernate_sequence'),'Opel', 'sedan', 'astra', 2005, 258, 4000, 'stock', 2, 'trash', 5.0,'JTHBB1BA2A2013500');
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating,vin)
VALUES (nextval('hibernate_sequence'),'Peugeot', 'hatchback', '308', 2021, 15, 26000, 'SE', 3, 'French tiger', 5.0,'1HGEM21292L047875');
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating,vin)
VALUES (nextval('hibernate_sequence'),'Nissan', 'crossover', 'X-Trail', 2018, 85, 22546, 'SEL', 4, 'best', 5.0,'JHLRE38357C030678');
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating,vin)
VALUES (nextval('hibernate_sequence'),'Volkswagen', 'crossover', 'Tuareg', 2016, 160, 36654, 'S', 1, 'WAG concern', 5.0,'JH4NA1150MT000683');
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating,vin)
VALUES (nextval('hibernate_sequence'),'Seat', 'hatchback', 'LEON', 2019, 58, 26000, 'S', 2, 'WAG concern', 5.0,'1FVHCYDJ85HV14123');
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating,vin)
VALUES (nextval('hibernate_sequence'),'Volvo', 'crossover', 'Q8', 2016, 160, 18500, 'SL', 4, 'WAG concern', 5.0,'2CTALDEW5A6370888');
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating,vin)
VALUES (nextval('hibernate_sequence'),'Honda', 'crossover', 'HCR', 2016, 160, 18500, 'SEL', 4, 'WAG concern', 5.0,'1B7GL22Z31S190315');

INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating,vin)
VALUES (nextval('hibernate_sequence'),'Acura', 'sedan', 'Legend', 1989, 560, 3500, 'SEL', 1, 'Japan', 2.1,'JH4KA3263KC011910');
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating,vin)
VALUES (nextval('hibernate_sequence'),'Acura', 'sedan', 'NSX', 1992, 378, 20001, 'SEL', 1, 'Japan', 5.0,'JH4NA1260NT000255');
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating,vin)
VALUES (nextval('hibernate_sequence'),'Chevrolet', 'sedan', 'Cavalier', 1998, 458, 4325, 'SEL', 1, 'Javan', 5.0,'3G1JC1245WS848211');
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating,vin)
VALUES (nextval('hibernate_sequence'),'Chevrolet', 'sedan', 'Blazer', 1982, 333, 8540, 'SEL', 1, 'American', 5.0,'1G8DC18H4CF114023');
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating,vin)
VALUES (nextval('hibernate_sequence'),'Jeep', 'crossover', 'Cherokee', 1999, 378, 5000, 'SEL', 1, 'JEEP', 5.0,'1J4FF68S0XL545426');
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating,vin)
VALUES (nextval('hibernate_sequence'),'GMC', 'crossover', 'Sierra', 1999, 160, 15000, 'SEL', 1, 'American', 5.0,'1GTGK29U5XE550656');
INSERT into car (id,name, type, model, year, mileage, price, equipment, company_entity_id, about, rating,vin)
VALUES (nextval('hibernate_sequence'),'Subaru', 'sedan', 'Impreza', 2013, 160, 18500, 'SEL', 1, 'WAG concern', 5.0,'JF1GR7E64DG203230');


