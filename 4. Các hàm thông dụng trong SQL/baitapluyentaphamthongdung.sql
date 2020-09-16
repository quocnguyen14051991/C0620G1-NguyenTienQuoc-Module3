cau 1:select Ten From nhanvien
where Ten like 'Huong'
cau 2:select Ten ,sum(SOTIEN) FROM nhanvien
goup by SOTIEN 
HAVING TEN like 'Huong'
cau3:
select distinct TEN FROM nhanvien