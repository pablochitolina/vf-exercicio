drop table if exists BUS_ROUTE;
drop table if exists LOCATION;
drop table if exists ITINERARY;


create table ITINERARY
(
    id            bigint auto_increment primary key not null,
    codigo VARCHAR(100)                      NOT NULL,
    nome               VARCHAR(100)                      NOT NULL

);

create table LOCATION
(
    id            bigint auto_increment primary key not null,
    itinerary_id            bigint ,
    lat  VARCHAR(20)                      NOT NULL,
    lng               VARCHAR(20)                      NOT NULL,
    FOREIGN KEY (itinerary_id) REFERENCES ITINERARY(id)
);

create table BUS_ROUTE
(
    id            bigint auto_increment primary key not null,
    itinerary_id            bigint,
    codigo VARCHAR(100)                      NOT NULL,
    nome               VARCHAR(100)                      NOT NULL,
    FOREIGN KEY (itinerary_id) REFERENCES ITINERARY(id)
);