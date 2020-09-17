create database if not exists demo;
use demo;
create table productss(
id int auto_increment primary key,
productcode varchar(50),
productname varchar(250),
productPrice double,
productAmount double,
productDescription varchar(250),
productStatus varchar(250)
);
insert into  productss(productcode,productname,productPrice,productAmount,productDescription,productStatus)
 values ('sp_004','omo',5000322,200,'bot giat quoc gia','ban chay'),
  ('sp_005','omomatic',500001,200,'bot giat quoc gia nhat ban','ban chay'),
  ('sp_003','omomatica',500011,200,'bot giat quoc gia nhat ban','ban chay');
  -- befor creat index--
 explain select  productcode from productss;
 create unique index productcode_index on productss(productcode);
create unique  index productcode_Composite_index on productss(productname,productPrice);
-- affter create index --
explain select  productcode from productss where productcode='sp_004' ;
explain select productname,productPrice from productss where productname='omo';
alter table productss drop index productcode_index;
alter table productss drop index productcode_Composite_index;
-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.--
create view productss_view as
select  productCode, productName, productPrice, productStatus
from productss;
 -- select trong view --
 select * from productss_view;
 -- cap nhat view -- 
 create or replace view productss_view as
 select  productCode, productName, productPrice, productStatus
 from productss
 where productname='omo';
select * from productss_view;
-- delete view
drop view productss_view;
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product --
delimiter //
create procedure getall_infor_produce()
begin
select * from productss;
end //
delimiter ;
-- su dung procedure -- 
call getall_infor_produce;
-- tao procedure them 1 san pham moi --
delimiter // 
create procedure insertnew_product(in productcodes varchar(50), in productnames varchar(250),in productPrices double,in productAmounts double,in productDescriptions varchar(250),in productStatuss varchar(250))
begin
insert into productss(productcode,productname,productPrice,productAmount,productDescription,productStatus) value(productcodes,productnames,productPrices,productAmounts,productDescriptions,productStatuss);
end //
delimiter ;
call insertnew_product('sp_005','motomatic',300,15,'xe may','ban cham');
select * from productss;
-- tao procedure sua thong tin san pham theo id --
delimiter //
create procedure edit_inforproduct(in id_edit int,in productcodes varchar(50), in productnames varchar(250),in productPrices double,in productAmounts double,in productDescriptions varchar(250),in productStatuss varchar(250) )
begin
update productss set productcode=productcodes,productname=productnames,productPrice=productPrices,productAmount=productAmounts,productDescription = productDescriptions,productStatus=productStatuss where id=id_edit;
end //
delimiter ;
call edit_inforproduct(1,'sp_008','sp tivi',500000,500,'tivi cua moi nha','ban ko chay ');
select * from productss;

-- Tạo store procedure xoá sản phẩm theo id--
delimiter //
create procedure delete_product(in id_delete int)
begin
delete from productss where id=id_delete; 
end //
delimiter ;
call delete_product(4);
select * from productss;

