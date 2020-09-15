create database thuchanhbai1;
use thuchanhbai1;
create table student(
id int primary key auto_increment,
`name` varchar(200),
birth_of_date varchar(200)
);
select * from student;
drop table student;