# Exercise 1
use Northwind;
select * from Products;

#Exercise 2
select * from Products
where ProductName = 'Queso Cabrales';

#Exercise 3
select ProductName, UnitsInStock
from Products
where ProductName in (
	'Laughing LumberJack Lager',
    'Outback Lager', 'Ravioli Angelo');

#Exercise 4
select * 
from Customers
where CustomerID = 'QUEDE';

#Exercise 5
select * 
from Orders
where Freight > 100.00
order by Freight;

#Exercise 6
select *
from Orders
where Freight between 10 and 20
	and ShipCountry = 'USA'
order by Freight;

#Exercise 7
select *
from Suppliers
where ContactTitle like 'Sales%';