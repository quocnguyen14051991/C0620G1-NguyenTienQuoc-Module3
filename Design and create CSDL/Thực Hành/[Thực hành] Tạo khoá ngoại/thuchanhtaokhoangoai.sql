create database thuchanhtaokhoangoai;
use thuchanhtaokhoangoai;
create table customers
(
id int auto_increment primary key,
name varchar(40),
address varchar(255),
email varchar(255)
);
create table `order`
(
id int auto_increment ,
staff varchar(50),
primary key (id),
customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES customers(id)
    
);