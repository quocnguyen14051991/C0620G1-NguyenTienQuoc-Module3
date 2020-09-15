create database sales_Managerment;
use sales_Managerment;
/* create table Offices*/
create table Offices(
officeCode  varchar(10) not null  primary key,
city  varchar(50) not null,
phone varchar(50) not null,
addressLine1 varchar(50) not null,
addressLine2 varchar(50) ,
state varchar(50) ,
country varchar(50) not null,
postalCode varchar(50) not null
);
/* create table employees */
create table Employees(
employeeNumber int  primary key,
lastName varchar(50) not null,
firstName varchar(50) not null,
email varchar(100) not null,
jobTitle varchar(50) not null,
reportTo int,
foreign key(reportTo) references Employees(employeeNumber),
officeCode varchar(10),
foreign key(officeCode) references Offices(officeCode)
);
/* Creat table customer*/
create table Customers(
customerNumber int not null ,
primary key(customerNumber),
customerName varchar(50) not null,
contactLastName  varchar(50) not null,
contactFirstName varchar(50) not null,
phone varchar(50) not null,
addressLine1 varchar(50) not null,
addressLine2 varchar(50) not null,
city varchar(50) not null,
state varchar(50) not null,
postalCode varchar(50) not null,
country varchar(50) not null,
creditLimit double,
salesRepEmployeeNumber  int,
foreign key(salesRepEmployeeNumber) references Employees(employeeNumber)
);
/* Creat table Orders */
create table Orders(
orderNumber int primary key,
orderDate datetime not null,
requiredDate datetime not null,
shippedDate datetime not null,
`status` varchar(15) not null,
`comment`text,
quantityOrdered int not null,
priceEach double not null,
customerOder int,
foreign key (customerOder) references Customers(customerNumber)
);
/*create table Payments */
create table Payments(
checkNumber varchar(50) not null primary key,
paymentDate datetime not null,
amount double not null,
customerPayment int,
foreign key (customerPayment) references Customers(customerNumber)
);
/* create table productlines */
create table ProductLines(
productLine varchar(50) not null primary key,
textDescription varchar(250),
image varchar(255)
);
/* create table products
*/
create table Products(
productCode varchar(15) not null primary key,
productName varchar(70) not null,
productScale varchar(10) not null,
productVendor varchar(50) not null,
productDescription text not null,
quantityInStock int not null,
buyPrice double not null,
MSRP double not null,
lineProduct varchar(50),
foreign key(lineProduct) references ProductLines(productLine)
);
/* create table OrderDetails  */
create table OrderDetails(
codeProduct  varchar(15),
numberOder int,
primary key(codeProduct,numberOder),
foreign key(codeProduct) references Products(productCode),
foreign key(numberOder) references Orders(orderNumber)
); 


drop database sales_Managerment



