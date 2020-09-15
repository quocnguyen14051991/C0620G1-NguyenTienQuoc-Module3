create database Thao_tác_với_bảng;

use Thao_tác_với_bảng;
create table contacts
(
contact_id int(11),
last_name varchar(30) not null,
first_name varchar(25),
birthday date,
CONSTRAINT contacts_pk PRIMARY KEY (contact_id)
);
create table suppliers
(
suppliers_id int(11) not null auto_increment,
suppliers_name varchar(50) not null,
account_rep varchar(50) not null default 'tbl',
constraint suppliers_pk primary key (suppliers_id)
);
alter table contacts
add contacts_sever varchar(50) not null
after contact_id;
alter table contacts
modify last_name varchar(50) null,
modify birthday int;
alter table contacts
drop column birthday;
alter table suppliers
change column suppliers_name suppliers_names
varchar(20);
alter table suppliers
rename to support;


drop table contacts,suppliers;

