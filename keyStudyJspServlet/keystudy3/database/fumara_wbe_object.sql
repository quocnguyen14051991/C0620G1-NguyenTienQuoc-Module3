use furama_case_study2_module3;
insert into customer_type (customer_type_id,customer_type_name ) 
	values 	(1,'Diamond'),
			(2,'Platinium'),
			(3,'Gold'),
			(4,'Silver'),
			(5,'Member');

insert into customer (customer_id,customer_type_id,customer_name,customer_birthday,
customer_gender,customer_id_card,customer_phone,customer_email,customer_address)
	values 	(4,1,'Hải','1968-12-20',b'1',18730113,039336258,'haiquacustomer_addressytay@gmail.com','Hà Tĩnh' ),
			(1,2,'Tùng','1995-11-16',b'0',18452213,069876258,'asda@gmail.com','Quảng Truong' ),
			(2,2,'Tùng','1995-11-16',b'0',18452213,069876258,'asda@gmail.com','Quảng Truong' ),
			(3,2,'Tùng','1995-11-16',b'0',18452213,069876258,'asda@gmail.com','Quảng Truong' ),
			(5,2,'Tùng','1995-11-16',b'0',18452213,069876258,'asda@gmail.com','Quảng Truong' ),
			(6,3,'khanh','1995-11-16',b'0',18452213,231321,'asdsa@gmail.com','Quảng Ninh' ),
			(7,4,'Linh','1995-11-16',b'0',18452213,2313,'sadas@gmail.com','Vinh' ),
			(8,3,'Thao','1995-11-16',b'1',18452213,069876258,'bxcb@gmail.com','Quảng Bình' ),
			(9,5,'Tan','1995-11-16',b'0',18452213,069876258,'erte@gmail.com','Hue' ),
			(10,3,'Giang','1995-11-16',b'1',76456465,069876258,'tungquayxe@gmail.com','Quảng Tri' ),
			(11,3,'Mai','1995-11-16',b'0',6446464646,069876258,'asdsa@gmail.com','Quảng Nam' ),
			(12,3,'Nghia','1995-11-16',b'0',18452213,069876258,'dfsd@gmail.com','Quảng Ngai' ),
			(13,4,'Trang','1995-11-16',b'1',123132131,069876258,'fadas@gmail.com','Quảng Chau' ),
			(14,5,'Vietlot','1997-06-20',b'1',196320113,037936588,'vbvbv@gmail.com','Đà Nẵng' );
            
            
insert into rent_type (rent_type_id,rent_type_name,rent_type_cost)
		values 	(1,'hour',300000),
				(2,'day',1000000),
				(3,'mont',150000000),
				(4,'year',150000000);
insert into service_type (service_type_id,service_type_name)    
		values 	(1,'Villa'),
				(2,'House'),
				(3,'Room');
	
            
insert into service(service_id,service_name,service_area,service_cost,service_max_people,rent_type_id,
	service_type_id,standard_room,description_orther_convenienve,pool_area,number_of_floors)	
		values		('1','Villa','150','250000',10,2,3,'Vip','Free',20.0,5),
					('2','Villa','200','300000',5,1,1,'Vip','Free',20.0,5),
					('3','House','120','150000',4,2,3,'Normal','Free',20.0,5),
					('4','Room','100','150000',5,1,3,'Normal','Free',40.0,5),
					('5','House','150','150000',6,4,1,'Normal','Free',20.0,5);
            
	insert into position (position_id,position_name)
		values 	('1','Giám đốc'),
				('2','Quản lý'),
				('3','Giám Sát'),
				('4','Chuyên Viên'),
				('5','Phục Vụ'),
				('6','Lễ Tân');
insert into education_degree (education_degree_id,education_degree_name) 
			values 	('1','Sau Đại Học'),
					('2','Đại Học'),
					('3','Cao Đẳng'),
					('4','Trung Cấp');
insert into division (division_id,division_name)    
					values 	('1','Quản Lý'),
							('2','Phục Vụ'),
							('3','Hành Chính'),
							('4','Sale-Marketing');
  insert into role (role_id,role_name)    
					values 	('1','Thánh Nổ'),
							('2','Chúa Hề'),
							('3','Fan Sky'),
							('4','Học trò thầy Huấn');    
    insert into user (username,password)    
					values 	('YeuBangConTim','HayLyTry'),
							('KhongCanDep','ChiCanGiau'),
							('FanArsenal','20Nam'),
							('ThanhTroll','legendary'),
							('YeuMauTim','GhetGiaDoi'),
							('NgheSyNhanDan','Lukaku');
    insert into employee (employee_id,employee_name,employee_birthday,employee_salary,employee_id_card,employee_phone,
		employee_email,employee_address,position_id,education_degree_id,division_id,username) 
        values 	('12','bao','1993-05-06','30000000','18242131','0311531452','hai@gmail.com','Vinh','2','1','4','YeuBangConTim'),
				('13','tu Sky','1999-10-20','50000000','13215465','0313564647','tung@gmail.com','Ha Noi','3','2','1','KhongCanDep'),
				('1','Hai Do','1998-12-25','50000000','13156465','03625236215','dat@gmail.com','Ca Mau','1','4','2','FanArsenal'),
				('2','Hai Do','1998-12-25','50000000','13156465','03625236215','dat@gmail.com','Ca Mau','1','4','2','FanArsenal'),
				('3','Hai Do','1998-12-25','50000000','13156465','03625236215','dat@gmail.com','Ca Mau','1','4','2','FanArsenal'),
				('14','Hai Do','1998-12-25','50000000','13156465','03625236215','dat@gmail.com','Ca Mau','1','4','2','FanArsenal'),
				('4','Tung son','1996-06-17','25000000','11346546','0931215615','thai@gmail.com','Vung Tau','4','3','3','ThanhTroll'),
				('5','Dat 09','1995-01-30','15000000','1231354165','0965431215','tung@gmail.com','Tran Huy Hung','6','2','2','YeuMauTim'),
				('7','Hoang','1995-06-30','15000000','123221331','0965431215','tra@gmail.com','Tran Huy Hung','6','2','2','YeuMauTim'),
				('8','Chuong','1995-07-30','15000000','6464656','0965431215','hai@gmail.com','Tran Huy Hung','4','2','2','YeuMauTim'),
				('9','Nhat','1995-02-28','20000000','1231354165','0965431215','bao@gmail.com','Tran Huy Hung','1','2','2','YeuMauTim'),
				('10','Quang','1995-08-30','35000000','1231354165','0965431215','dasd@gmail.com','Tran Huy Hung','3','2','2','YeuMauTim'),
				('11','Tra','1995-01-30','20000000','1231354165','0965431215','madasdi@gmail.com','Tran Huy Hung','6','2','2','YeuMauTim'),
				('6','Hien map','1993-04-06','18000000','231134654','0964531135','ewrwe@gmail.com','Hue','5','1','4','NgheSyNhanDan');
      insert into attach_service (attach_service_id,attach_service_name,attach_service_cost,attach_service_unit,attach_service_status)     
			values 	('1','massage','200000','3','activity'),
					('2','food','100000','10','activity'),
					('3','Drinks','50000','10','activity'),
					('4','Karaoke','500000','4','activity'),
					('5','Car Move','200000','5','inactive');
    insert into   contract(contract_id,contract_start_date,contract_end_date,contract_deposit,
          contract_total_money,employee_id,customer_id,service_id)
				values 	('1','2018-12-24','2020-12-12','70000000','200000000','2','1','1'),
						('2','2016-07-26','2018-10-25','69000000','180000000','3','4','2'),
						('3','2019-04-20','2020-03-30','40000000','360000000','4','3','3'),
						('4','2017-03-24','2019-03-11','96000000','20000000','5','5','5'),
						('5','2018-12-14','2019-11-12','36000000','190000000','1','6','1'),
						('6','2019-04-04','2020-02-01','400000000','200000000','2','7','3'),
						('7','2018-08-06','2022-08-15','400000000','200000000','5','8','4'),
						('8','2018-11-05','2021-01-26','400000000','200000000','1','9','2'),
						('9','2018-10-03','2020-11-08','55000000','200000000','6','10','5'),
						('10','2018-08-15','2020-06-09','400000000','250000000','3','2','5'),
						('11','2019-09-26','2023-05-26','600000000','240000000','7','11','1'),
						('12','2018-03-12','2020-03-22','400000000','360000000','4','13','3');                
        insert into  contract_detail (contract_detail_id,contract_id,attach_service_id,quantity)             
                values 	('1','1','1','200000000'),    
						('2','2','5','60000000'),    
						('3','3','5','70000000'),    
						('4','4','2','20000000'),    
						('5','5','4','3000000'),    
						('6','6','1','40000000'),    
						('7','7','3','50000000'),    
						('8','8','3','60000000'),    
						('10','10','4','7000000'),    
						('11','11','1','5000000'),    
						('12','12','5','2000000'),    
						('9','9','2','60000000');  
                        
          
       