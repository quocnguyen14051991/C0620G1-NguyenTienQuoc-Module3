create database xacdinhkhoachinhvakhoangoai;
use xacdinhkhoachinhvakhoangoai;
create table customer
(
customer_number int primary key,
fullname varchar(200),
address varchar(200),
email varchar(200),
phone varchar(200)
);
create table accounts
(
account_number int primary key,
account_type varchar(200),
`date` date,
balance int ,
customer_number int,
foreign key(customer_number) references customer(customer_number)
);
create table Transactions 
(
tran_number  int primary key,
account_number int ,
datetran date,
amount int,
`description` varchar(200),
acount_number int,
foreign key(acount_number) references accounts(account_number)
);