DROP TABLE IF EXISTS location;

DROP TABLE IF EXISTS itinerary;

DROP TABLE IF EXISTS bus_route;

CREATE TABLE bus_route
  (
     id           BIGINT auto_increment PRIMARY KEY NOT NULL,
     codigo       VARCHAR(10) NOT NULL,
     nome         VARCHAR(100) NOT NULL
  );

CREATE TABLE itinerary
  (
     id     BIGINT auto_increment PRIMARY KEY NOT NULL,
     bus_route_id BIGINT,
     codigo VARCHAR(10) NOT NULL,
     nome   VARCHAR(100) NOT NULL,
     FOREIGN KEY (bus_route_id) REFERENCES bus_route(id)
  );

CREATE TABLE location
  (
     id           BIGINT auto_increment PRIMARY KEY NOT NULL,
     itinerary_id BIGINT,
     lat          DOUBLE NOT NULL,
     lng          DOUBLE NOT NULL,
     FOREIGN KEY (itinerary_id) REFERENCES itinerary(id)
  );

