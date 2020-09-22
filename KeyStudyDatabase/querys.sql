/*Task1  :insert data--
*/

/*
Task2  :2.	Hiển thị thông tin của tất cả nhân viên có
trong hệ thống có tên bắt đầu là một trong các
ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
*/
/* trường hợp 1 nếu chỉ lấy tên ko lấy tên họ đầy đủ */

use database_furama_resort;
select *,
SUBSTRING_INDEX(nhanvien.HoTen,' ',-1 ) as ten
from nhanvien 
where CHAR_LENGTH(HoTen)<=15
and (SUBSTRING_INDEX(nhanvien.HoTen,' ',-1 ) like 'H%' or SUBSTRING_INDEX(nhanvien.HoTen,' ',-1 ) like 'T%' or SUBSTRING_INDEX(nhanvien.HoTen,' ',-1 ) like 'K%');

/* trường hợp 2: lấy đầy đủ họ tên */
use database_furama_resort;
select * from nhanvien 
where
CHAR_LENGTH(HoTen)<=15
AND ( HoTen like 'H%' or HoTen like 'T%' or HoTen like 'K%');


/*Hiển thị thông tin của tất cả khách hàng có độ 
tuổi từ 18 đến 50 tuổi và 
có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”. */

select * from khachhang
where DiaChi in ('Đà Nẵng' ,'Quảng Trị') and 
TIMESTAMPDIFF(year,NgaySinh, CURDATE()) between 18 and 50;  -- Dùng trong trường hợp tính tuổi theo ngày tháng năm
-- (year(now())-year(NgaySinh)) between 18 and 50; -- Dùng trong trường hợp tính tuoi theo năm
-- select TIMESTAMPDIFF(year,NgaySinh, CURDATE()) as tuoi from khachhang trả về tuổi của khách hàng-- 

 /* 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt
 phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần
 theo số lần đặt phòng của khách hàng. 
 Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
 */
 
 select kh.*,lk.TenLoaiKhach,hd.idHopDong,count(hd.idhopdong) tongbook
 from khachhang kh
 inner join loaikhach lk on kh.LoaiKhach_idLoaiKhach=lk.idLoaiKhach and lk.TenLoaiKhach='Diamond' -- lấy được tất cả khách hàng với loại khách 
 inner join hopdong hd on hd.KhachHang_idKhachHang=kh.idKhachHang
 group by kh.HoTen
 order by tongbook;
 
 
 /* 

 cách 2:
select kh.idkhachhang,kh.LoaiKhach_idLoaiKhach,kh.hoten,lk.TenLoaiKhach,count(idhopdong)  tong
from khachhang kh 
inner join loaikhach lk on kh.LoaiKhach_idLoaiKhach=lk.idLoaiKhach
right join hopdong hd on kh.idKhachHang=hd.KhachHang_idKhachHang
group by kh.HoTen
having lk.TenLoaiKhach='Diamond'
order by tong; */

/* 5.Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, 
NgayLamHopDong, NgayKetThuc, TongTien (Với TongTien được tính theo công thức như sau:
 ChiPhiThue + SoLuong*Gia với SoLuong và Giá là từ bảng DichVuDiKem) cho tất cả các Khách hàng đã từng đặt phỏng.
 (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
*/
select 
	kh.idKhachHang,
	kh.HoTen,
    lk.TenLoaiKhach,
    hd.idHopDong,
    dv.tendichvu,
    hd.NgayLamHopDong,
    hd.NgayKetThuc,
    CASE WHEN hd.idHopDong  is not null THEN 
			(select SUM(dv.ChiPhiThue+ hdct.SoLuong * dvdk.Gia) as TongTien
				from hopdongchitiet hdct
				left join dichvudikem dvdk on dvdk.idDichVuDiKem=hdct.DichVuDiKem_idDichVuDiKem and hdct.HopDong_idHopDong = hd.idHopDong)
		ELSE null
	END AS tongtien
from khachhang kh
inner join loaikhach lk on lk.idLoaiKhach=kh.LoaiKhach_idLoaiKhach
left join hopdong hd on hd.KhachHang_idKhachHang = kh.idKhachHang
left join dichvu dv on dv.idDichVu=hd.DichVu_idDichVu;


/*
6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các 
	loại Dịch vụ chưa từng được Khách
	hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
*/
select dv.idDichVu, dv.TenDichVu, dv.DienTich, ldv.TenLoaiDichVu, ldv.TenLoaiDichVu	,hd.idHopDong,hd.NgayLamHopDong
from dichvu dv
inner join loaidichvu ldv on ldv.idLoaiDichVu=dv.LoaiDichVu_idLoaiDichVu
right join hopdong hd on dv.idDichVu = hd.DichVu_idDichVu
where dv.idDichVu not in
-- không nằm trong danh sách mà có đơn đặt loại dịch vụ này từ 1-1-2019 -- 
(select DichVu_idDichVu from hopdong
where hopdong.NgayLamHopDong > '2019-01-01'
);

/*
7.Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, 
TenLoaiDichVu của tất cả các loại dịch vụ đã từng được 
Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.
*/
select dv.iddichvu,dv.tendichvu,dv.dientich,dv.songuoitoida,dv.chiphithue,ldv.tenloaidichvu,hd.NgayLamHopDong
from dichvu dv
left join loaidichvu ldv on ldv.idLoaiDichVu= dv.LoaiDichVu_idLoaiDichVu
left join hopdong hd on hd.DichVu_idDichVu=dv.idDichVu
where dv.idDichVu not in
-- không nằm trong danh sách các hợp đồng năm 2019--
(select hopdong.DichVu_idDichVu from hopdong 
where year(hopdong.NgayLamHopDong) ='2019'
) and year(hd.NgayLamHopDong) = '2018';

/* 
8.Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu
HoThenKhachHang không trùng nhau.
Học viên sử dụng theo 3 cách khác
nhau để thực hiện yêu cầu trên
*/
/* cách 1:
*/
select distinct hoten from khachhang;
/* cách 2 */
select hoten from khachhang
group by HoTen;
/* cách 3 */
select hoten from khachhang
union
select hoten from khachhang;

/* 
9.	Thực hiện thống kê doanh thu theo tháng, 
nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
*/
/* 
cách 1:
*/
SELECT DATE_FORMAT(hd.ngaylamhopdong, "%m-%Y") AS thang, COUNT(*) as tonghd
FROM hopdong hd
WHERE year(NgayLamHopDong)='2019'
GROUP BY thang;

/* cách 2 */
select 
	DATE_FORMAT(m1, '%b') as rp_Month,
    (select count(*) from hopdong hd where year(hd.NgayLamHopDong) = '2019'
    and DATE_FORMAT(hd.NgayLamHopDong, '%b') = rp_Month) as rp_tongHD
from
	(select  ('2019-01-01') + INTERVAL m MONTH as m1
		from (select @rownum:=@rownum+1 as m 
				from (select 1 union select 2 union select 3 union select 4) t1,
					(select 1 union select 2 union select 3 union select 4) t2,
					(select 1 union select 2 union select 3 union select 4) t3,
					(select 1 union select 2 union select 3 union select 4) t4,
					(select @rownum:=-1) t0) d1
	) d2 
where m1 <= '2019-12-30'
order by m1;



/*
10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ 
đi kèm. Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc,
 TienDatCoc, SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet).
*/
select hd.idHopDong,hd.NgayLamHopDong,hd.NgayKetThuc,hd.TienDatCoc,
count(hdct.idHopDongChiTiet)  SoluongDichVuDikem
from hopdong hd
left join hopdongchitiet hdct
on hd.idHopDong = hdct.HopDong_idHopDong
group by hd.idHopDong;

/* 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang
 là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
*/

/*
cách 1:
select dichvudikem.* , loaikhach.TenLoaiKhach, khachhang.DiaChi
from hopdongchitiet hdct
inner join hopdong on hdct.HopDong_idHopDong=hopdong.idHopDong
inner join khachhang on khachhang.idKhachHang = hopdong.KhachHang_idKhachHang and khachhang.DiaChi in ('Vinh','Quảng Ngãi')
inner join loaikhach on loaikhach.idLoaiKhach = khachhang.LoaiKhach_idLoaiKhach and loaikhach.TenLoaiKhach='Diamond'
inner join dichvudikem on dichvudikem.idDichVuDiKem = hdct.DichVuDiKem_idDichVuDiKem
group by idDichVuDiKem 
*/

select dvdk.* , lk.TenLoaiKhach, kh.DiaChi
from khachhang kh
inner join loaikhach lk on lk.idLoaiKhach = kh.LoaiKhach_idLoaiKhach and lk.TenLoaiKhach='Diamond' and kh.DiaChi in ('Vinh','Quảng Ngãi')
left join hopdong hd on kh.idKhachHang = hd.KhachHang_idKhachHang
left join hopdongchitiet hdct on hd.idHopDong = hdct.HopDong_idHopDong
inner join dichvudikem dvdk on dvdk.idDichVuDiKem = hdct.DichVuDiKem_idDichVuDiKem;

/*
12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang,
 TenDichVu, SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc
 của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 
tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.
.....buồn nghủ quá ko làm nữa
*/
select hd.idHopDong
, nv.HoTen as Tennhanvien
, kh.HoTen as Tenkhachang
, kh.SDT as SoDienThoaiKhachHang
, dv.TenDichVu
, hd.TienDatCoc
, count(hdct.idHopDongChiTiet) as soluong
from hopdong hd
inner join dichvu dv on hd.DichVu_idDichVu = dv.idDichVu and hd.NgayLamHopDong BETWEEN '2019-09-01' AND '2019-12-30'
														and dv.idDichVu not in (select dv.idDichVu
														from hopdong hd
														inner join dichvu dv on hd.DichVu_idDichVu = dv.idDichVu 
														where hd.NgayLamHopDong BETWEEN '2019-01-01' AND '2019-06-30')
inner join nhanvien nv on nv.idNhanVien = hd.NhanVien_idNhanVien
inner join khachhang kh on hd.KhachHang_idKhachHang = kh.idKhachHang
left join hopdongchitiet hdct on hd.idHopDong = hdct.HopDong_idHopDong
group by hd.idHopDong;
 -- có thể dùng union select ds 3 tháng cuối năm union đanh sách 6 tháng đầu năm rồi loại 
/* 
13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.
 (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau). 
*/
select dvdk.* , count(hdct.DichVuDiKem_idDichVuDiKem) as soluongdat
	from hopdongchitiet hdct
	inner join dichvudikem dvdk on hdct.DichVuDiKem_idDichVuDiKem = dvdk.idDichVuDiKem
	group by hdct.DichVuDiKem_idDichVuDiKem
    having soluongdat = (Select MAX(dv.soluongdadat) 
						FROM 
							(select count(hdct.DichVuDiKem_idDichVuDiKem) as soluongdadat
							from hopdongchitiet hdct
							inner join dichvudikem dvdk on hdct.DichVuDiKem_idDichVuDiKem = dvdk.idDichVuDiKem
							group by hdct.DichVuDiKem_idDichVuDiKem) as dv);
/* 
14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung. 
*/
select dvdk.TenDichVuDiKem, count(hdct.DichVuDiKem_idDichVuDiKem) soluongdat
from hopdongchitiet hdct
inner join dichvudikem dvdk on hdct.DichVuDiKem_idDichVuDiKem = dvdk.idDichVuDiKem
group by hdct.DichVuDiKem_idDichVuDiKem
having soluongdat = 1;
                            
/* 15.Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, 
TrinhDo, TenBoPhan, SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019. 
*/
select nv.*,td.TrinhDo,bp.TenBoPhan,nv.SDT,nv.DiaChi,count(hd.NhanVien_idNhanVien) sohd
from hopdong hd
inner join nhanvien nv on hd.NhanVien_idNhanVien=nv.idNhanVien and (hd.NgayLamHopDong between '2018-01-01' and '2019-01-01')
inner join trinhdo td on td.idTrinhDo=nv.TrinhDo_idTrinhDo
inner join bophan bp on nv.BoPhan_idBoPhan=bp.idBoPhan
group by hd.NhanVien_idNhanVien
having sohd<=3;
/*
Select nv.idNhanVien, nv.HoTen, count(hd.NhanVien_idNhanVien) as sohd
from 
	hopdong hd
	inner join nhanvien nv on hd.NhanVien_idNhanVien = nv.idNhanVien
where
	hd.NgayLamHopDong between '2018-01-01' and '2019-01-01'
group by hd.NhanVien_idNhanVien
having sohd <= 3;
*/

/*16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.=> 
Kiểm tra danh sách các nhân viên chưa có hợp đồng 2017-2019.
 Xóa theo thứ tự: hợp đồng chi tiết -> hợp đồng -> nhân viên.
 */
delete from nhanvien where idNhanVien not in (
select hopdong.NhanVien_idNhanVien
from hopdong
 where year(hopdong.ngaylamhopdong) between 2017 and 2019
);

/*
Task 17:

 */

 update khachhang set khachhang.LoaiKhach_idLoaiKhach = 1 where idkhachhang in (
 select idkhachhang
 from(
 select idkhachhang , ( tiendatcoc+ sum(dichvudikem.gia*soluong))as tong
 from  hopdongchitiet
 join hopdong on hopdongchitiet.HopDong_idHopDong=hopdong.idhopdong
 join khachhang on hopdong.KhachHang_idKhachHang=khachhang.idkhachhang
 join dichvudikem on dichvudikem.iddichvudikem=hopdongchitiet.DichVuDiKem_idDichVuDiKem
 where year(hopdong.ngaylamhopdong)=2019 and  LoaiKhach_idLoaiKhach=2
 group by idkhachhang
 having tong>5000) as tam);
 

/*
 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).
*/
delete from khachhang where idKhachHang   in ( select idKhachHang
from hopdong
 where year(hopdong.ngaylamhopdong) < 2016);

/*
Task 19
 
*/

 update  dichvudikem set gia = gia*10 where gia in(
 select gia 
 from(
 select gia,count(hopdongchitiet.DichVuDiKem_idDichVuDiKem) as soluongdv
from hopdong
join khachhang on khachhang.idkhachhang= hopdong.KhachHang_idKhachHang
join dichvu on dichvu.iddichvu=hopdong.dichvu_iddichvu
join hopdongchitiet on hopdongchitiet.hopdong_idhopdong=hopdong.idhopdong
join dichvudikem on hopdongchitiet.dichvudikem_iddichvudikem=dichvudikem.iddichvudikem
where year(ngaylamhopdong)=2019
group by idhopdong
having soluongdv>3 )as tam);


/*
Task 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, 
thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi. 
*/
select nv.idNhanVien as id,nv.HoTen,nv.Email,nv.SDT,nv.NgaySinh,nv.DiaChi
from nhanvien nv
union all
select kh.idKhachHang, kh.HoTen, kh.Email, kh.SDT, kh.NgaySinh, kh.DiaChi
from khachhang kh;

/* 21.	Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên
 có địa chỉ là “Hải Châu” và đã từng lập hợp đồng cho 1
 hoặc nhiều Khách hàng bất kỳ  với ngày lập hợp đồng là “12/12/2019” */
 /* cách 1 */
 drop view if exists V_NHANVIEN;
 create view V_NHANVIEN as 
 select * from nhanvien nv where 
 nv.diachi="Hải Châu" 
 and 
 exists (select * 
 from hopdong hd where hd.nhanvien_idnhanvien = nv.idnhanvien and hd.ngaylamhopdong="2019-12-12");
 select * from V_NHANVIEN;
 /* cách 2 */
 drop view if exists V_NHANVIEN;
 create view V_NHANVIEN as 
 select * from nhanvien nv where 
 nv.diachi="Hải Châu" 
 and nv.idnhanvien in (select hd.nhanvien_idnhanvien from hopdong hd where hd.nhanvien_idnhanvien=nv.idnhanvien);
 
 /* 22.	Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu”
 đối với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này. */
 update V_NHANVIEN  set V_NHANVIEN.diachi="Liên Chiểu";
 
 /* 23.	Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó
 với Id Khách hàng được truyền vào như là 1 tham số của Sp_1 */
 delimiter //
 drop procedure if exists sp_1 //
 create procedure sp_1(idkhachhang int)
 begin
 delete from khachhang where khachhang.idkhachhang=idkhachhang ;
 end // 
 delimiter ;
call sp_1(1);
/* 24.	Tạp Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu Sp_2 
phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung,
 với nguyên tắc không được trùng khó chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.
 */
 delimiter //
 drop procedure if exists sp_2 //
 create procedure sp_2(in id_hd int,in id_nv int,in id_dv int,in ngaylam_hd date,
 in ngay_kt varchar(45),in tien_dat_coc double,in tongtien double)
 begin
	declare mesages varchar(255) ;
	if not exists (select idhopdong	 from hopdong where hopdong.idhopdong=id_hd) then
		set mesages="đã tồn tại primary key";
	elseif not exists (select idnhanvien from nhanvien where nhanvien.idnhanvien=id_nv) then
		set mesages="không tồn tại id của nhân viên trong bảng nhân viên";
	elseif not exists (select iddichvu from dichvu where dichvu.iddichvu=id_dv)  then 
		set mesages="không tồn tại id trong bang dich vu ";
	else 
	set mesages="ok";
	insert into hopdong(idHopdong,nhanvien_idnhanvien,khachhang_idkhachhang,dichvu_iddichvu,ngaylamhopdong,
	ngayketthuc,tiendatcoc,tongtien) values(id_hd,id_nv,id_dv,ngaylam_hd,ngay_kt,tien_dat_coc,tongtien);
	end if;
	select mesages;
 end //
 delimiter ;
 call sp_2(1,1,333,"2000-02-02","2020-02-09",33,33);
 
 select * from hopdong
 /* 25.	Tạo triggers có tên Tr_1 Xóa bản ghi trong bảng HopDong thì hiển thị tổng số 
 lượng bản ghi còn lại có trong bảng HopDong ra giao diện console của database */


 /* 26.	Tạo triggers có tên Tr_2 Khi cập nhật Ngày kết thúc hợp đồng, cần kiểm tra
 xem thời gian cập nhật có phù hợp hay không, với quy tắc sau: Ngày kết thúc hợp đồng phải lớn hơn
 ngày làm hợp đồng ít nhất là 2 ngày. Nếu dữ liệu hợp lệ thì cho phép cập nhật, nếu dữ liệu không
 hợp lệ thì in ra thông báo
 “Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” trên console của database
 */
 
 /* 27.	Tạo user function thực hiện yêu cầu sau:
a.	Tạo user function func_1: Đếm các dịch vụ đã được sử dụng với Tổng tiền là > 2.000.000 VNĐ.
b.	Tạo user function Func_2: Tính khoảng thời gian dài nhất tính từ lúc bắt đầu làm hợp đồng đến
 lúc kết thúc hợp đồng mà Khách hàng đã thực hiện thuê dịch vụ (lưu ý chỉ xét các khoảng thời gian 
 dựa vào từng lần làm hợp đồng thuê dịch vụ, không xét trên toàn bộ các lần làm hợp đồng). 
 Mã của Khách hàng được truyền vào như là 1 tham số của function này. */
 delimiter //
drop function if exists func_1 //
create function func_1()
returns int
reads sql data
 begin
 declare tong int default 0;
 select count(hd.idhopdong) into tong 
 from hopdong hd
 where hd.tongtien > 2000000
 group by dichvu_iddichvu;
 return tong;
 end // 
 delimiter ;
 select func_1() as tinhtong;
 
 delimiter //
 drop function if exists Func_2 //
 create function Func_2(id_khachhang int)
 returns int
 reads sql data
 begin
	declare maxday int;
	select max(datediff(ngayketthuc,ngaylamhopdong)) into maxday
	from hopdong hd
	inner join khachhang kh on kh.idkhachhang=hd.khachhang_idkhachhang
	inner join dichvu dv on hd.dichvu_iddichvu=dv.iddichvu
	where idkhachhang=id_khachhang;
    return maxday;
 end //
 delimiter ;
 select Func_2(2);
 
/*
28.	Tạo Store procedure Sp_3 để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ 
là “Room” từ đầu năm 2015 đến hết năm 2019 để xóa thông tin của các dịch vụ đó (tức là xóa các bảng ghi 
trong bảng DichVu) và xóa những HopDong sử dụng dịch vụ 
liên quan (tức là phải xóa những bản gi trong bảng HopDong) và những bản liên quan khác.
*/
 delimiter //
 drop procedure if exists Sp_3 //
 create procedure Sp_3()
 begin
	delete from hopdongchitiet 
		where hopdongchitiet.hopdong_idhopdong =any(select idhopdong from hopdong
		where hopdong.dichvu_iddichvu=( select * from (select distinct iddichvu
		from (hopdong hd
		inner join khachhang kh on kh.idkhachhang=hd.khachhang_idkhachhang
		inner join dichvu dv on hd.dichvu_iddichvu=dv.iddichvu
		inner join loaidichvu on dv.loaidichvu_idloaidichvu=loaidichvu.idloaidichvu) 
		where year(ngayketthuc) between '2015' and '2019' and tenloaidichvu='room') tbl_delete));
   
 delete from hopdong 
	where dichvu_iddichvu=any(select * from (
		select distinct iddichvu
		from hopdong hd
		inner join khachhang kh on kh.idkhachhang=hd.khachhang_idkhachhang
		inner join dichvu dv on hd.dichvu_iddichvu=dv.iddichvu
		inner join loaidichvu on dv.loaidichvu_idloaidichvu=loaidichvu.idloaidichvu 
		where year(ngayketthuc) between '2015' and '2019' and tenloaidichvu='room') tbl_d);
    
 delete from dichvu
	where iddichvu=(select *
		from (select distinct iddichvu
		from hopdong hd
		inner join khachhang kh on kh.idkhachhang=hd.khachhang_idkhachhang
		inner join dichvu dv on hd.dichvu_iddichvu=dv.iddichvu
		inner join loaidichvu on dv.loaidichvu_idloaidichvu=loaidichvu.idloaidichvu
		where year(ngayketthuc) between '2015' and '2019' and tenloaidichvu='room') tbl_delete);

 end //
 delimiter ;
 call Sp_3();

 
 
 



