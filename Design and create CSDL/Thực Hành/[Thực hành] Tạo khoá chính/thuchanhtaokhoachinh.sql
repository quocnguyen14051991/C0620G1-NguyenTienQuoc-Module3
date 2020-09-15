create database thuchanhtaokhoachinh;
create table users
(
user_id int auto_increment primary key,
username varchar(200),
passwords varchar(255),
email varchar(255)
);
create table roles
(
roles_id int auto_increment,
role_name varchar(50),
primary key(roles_id)
);
CREATE TABLE user_roles(
   user_id INT NOT NULL,
   roles_id INT NOT NULL,
   PRIMARY KEY(user_id,roles_id),
   FOREIGN KEY(user_id) REFERENCES users(user_id),
   FOREIGN KEY(roles_id) REFERENCES roles(roles_id)
);