create database library_management;
use library_management;

create table category_book(
id_category int primary key,
type_name_book varchar(50) not null unique
);

create table book(
id_book int primary key,
name_book varchar(50) not null ,
publishing_company varchar(50) not null,
author varchar(50) null,
Publishing_year datetime not null,
number_of_editions int not null,
price double not null ,
image tinyint,
id_category int,
foreign key(id_category) references category_book(id_category)
);

create table address(
id_address int primary key,
address1 varchar(500) not null,
address2 varchar(500)
);

create table student(
student_number int primary key,
student_name varchar(50) not null ,
id_address int,
foreign key (id_address) references address(id_address),
email varchar(50) not null ,
image tinyint
);

create table borroworder(
id_borrowoder int primary key,
borrow datetime not null ,
payday datetime not null,
student_number int  ,
id_book int,
foreign key(student_number) references student(student_number)
);

create table detailborroworder(
id_detailborroworder int primary key,
id_borrowoder int,
id_book int,
limit_borrow_day int default 7, 
limit_borrow_book int default 10,
foreign key(id_borrowoder) references borroworder(id_borrowoder),
foreign key(id_book) references book(id_book)
);


