create database productmaintenance;
use productmaintenance;

 drop table product;

create table product(
	code char(255) not null primary key,
    description varchar(255),
    price float
);

INSERT INTO product(code, description, price) VALUES('5', 'sssss', 123);
INSERT INTO product(code, description, price) VALUES('9', 'saaaa', 123);
INSERT INTO product(code, description, price) VALUES('1', 'sssss', 123);
INSERT INTO product(code, description, price) VALUES('6', 'sssss', 123);
INSERT INTO product(code, description, price) VALUES('8601', '86(the band) - True Life Songs and Pictures', 14.95);
INSERT INTO product(code, description, price) VALUES('pf01', 'Paddlefoot - The first CD', 12.95);
INSERT INTO product(code, description, price) VALUES('pf02', 'Paddlefoot - The second CD', 14.95);
INSERT INTO product(code, description, price) VALUES('pf03', 'Joe Rut - Denuine Wood Grained Finish', 14.95);