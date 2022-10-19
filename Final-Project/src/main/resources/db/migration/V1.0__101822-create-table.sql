CREATE TABLE IF NOT EXISTS role(
    _id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    role VARCHAR(255) NULL
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS user(
_id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
email VARCHAR(255) NULL,
password VARCHAR(255) NULL,
first_name VARCHAR(255) NULL,
last_name VARCHAR(255) NULL,
roles_id INT(11) NOT NULL,
FOREIGN KEY(roles_id) REFERENCES role(_id)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS agency(
    _id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(255),
    name VARCHAR(255),
    details VARCHAR(255),
    owner INT(11),
    FOREIGN KEY(owner) REFERENCES user(_id)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS ticket(
    _id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    seat_number INT(11),
    cancellable INT(11),
    journey_date VARCHAR(255),
    passenger INT(11),
    FOREIGN KEY(passenger) REFERENCES user(_id)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS bus(
       _id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
       code VARCHAR(255),
       capasity INT(11),
       make VARCHAR(255),
       agency INT(11),
       FOREIGN KEY(agency) REFERENCES agency(_id)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS stop(
         _id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
         code VARCHAR(255),
         name VARCHAR(255),
         detail VARCHAR(255)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS trip(
    _id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    fare INT(11),
    journey_time VARCHAR(255),
    source_stop INT(11),
    des_stop INT(11),
    bus INT(11),
    agency INT(11),
    FOREIGN KEY(agency) REFERENCES agency(_id),
    FOREIGN KEY(bus) REFERENCES bus(_id),
    FOREIGN KEY(source_stop) REFERENCES stop(_id),
    FOREIGN KEY(des_stop) REFERENCES stop(_id)
)ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS tripschedule(
     _id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
     trip_date VARCHAR(255),
     avalable_seats INT(11),
     trip_detail INT(11),
     ticket_sold INT(11),
     FOREIGN KEY(trip_detail) REFERENCES trip(_id),
     FOREIGN KEY(ticket_sold) REFERENCES ticket(_id)
)ENGINE=InnoDB;


