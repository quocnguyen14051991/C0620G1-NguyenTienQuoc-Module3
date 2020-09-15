use `classicmodels`;
select * from customers
limit 0,30;
select * from customers
where customerName='Atelier graphique'
limit 0,30;
select * from customers
where customerName like '%A%'
limit 0,30;
select * from customers
where city
in (
'Nantes','Las Vegas','Warszawa','NYC')
limit 0,30;