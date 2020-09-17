-- thuc hanh tao view--
CREATE VIEW customer_views AS

SELECT customerNumber, customerName, phone

FROM  customers;
select * from customer_views;
CREATE OR REPLACE VIEW customer_views AS

SELECT customerNumber, customerName, contactFirstName, contactLastName, phone

FROM customers
-- cập nhật view -- 
WHERE city = 'Nantes';

-- xóa view--
DROP VIEW customer_views;