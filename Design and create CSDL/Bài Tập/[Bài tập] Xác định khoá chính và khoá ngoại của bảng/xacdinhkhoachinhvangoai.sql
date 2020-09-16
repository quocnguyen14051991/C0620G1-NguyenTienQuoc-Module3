drop database if exists key_furama_resort ;
create database key_furama_resort;
use key_furama_resort;
create table vitri(
id int primary key,
tenvitri varchar(45)
);
create table trinhdo(
id int primary key,
trinhdo varchar(45)
);
create table bophan(
id int primary key,
tenbophan varchar(45)
);
create table dichvudikem(
id int primary key,
tendichvudikem varchar(45),
gia int,
donvi int,
trangthaikhadung varchar(45)
);
create table loaikhach(
id int primary key ,
tenloaikhach varchar(45)
);
create table kieuthue(
id int primary key,
tenkieuthue varchar(45),
gia int
);
create table loaidichvu(
id int primary key,
tenloaidichvu varchar(45)
);
create table nhanvien(
id int primary key,
hoten varchar(50),
id_vitri int,
id_trinhdo int,
id_bophan int,
foreign key(id_vitri) references vitri(id),
foreign key (id_trinhdo) references trinhdo(id),
foreign key(id_bophan) references bophan(id),
ngaysinh date ,
socmtnd varchar(45),
luong varchar(45),
sdt varchar(45),
email varchar(45),
diachi varchar(45)
);
create table khachhang(
id int primary key,
id_loaikhach int ,
foreign key(id_loaikhach) references loaikhach(id),
hoten varchar(45),
ngaysinh date,
socmtnd varchar(45),
sdt varchar(45),
email varchar(45),
diachi varchar(45)
);
create table dichvu(
id int primary key,
tendichvu varchar(45),
dientich int,
sotang int,
songuoitoida varchar(45),
chiphithue varchar(45),
id_kieuthue int,
id_loaidichvu int,
foreign key(id_kieuthue) references kieuthue(id),
foreign key(id_loaidichvu) references loaidichvu(id),
trangthai varchar(45)
);
create table hopdong(
id int primary key,
id_nhanvien int,
id_khachhang int,
id_dichvu int,
foreign key(id_nhanvien) references nhanvien(id),
foreign key(id_khachhang) references khachhang(id),
foreign key(id_dichvu) references dichvu(id),
ngaylamhopdong date,
ngayketthuc date ,
tiendatcoc int,
tongtien int
);
create table hopdongchitiet(
id int primary key,
id_hopdong int,
id_dichvudikem int,
foreign key(id_hopdong) references hopdong(id),
foreign key(id_dichvudikem) references dichvudikem(id),
soluong int
);
