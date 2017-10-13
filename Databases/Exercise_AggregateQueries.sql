/*
	Find the average freight paid for orders 
	placed by companies in the USA

USE Northwind;
select avg(o.Freight) as FreightAverage
from Orders o
inner join Customers c on o.CustomerID = c.CustomerID
where c.Country = 'USA';
*/

/*
	Find the gross total (sum of quantity * unit price) for 
	all orders placed by B's Beverages and Chop-suey Chinese.

use Northwind;
select sum(od.UnitPrice * od.Quantity) as GrossTotal
from Order_Details od
inner join Orders o on od.OrderID = o.OrderID
inner join Customers c on c.CustomerID = o.CustomerID
where c.CompanyName in ('B''s Beverages', 'Chop-suey Chinese');

SELECT SUM(Quantity * UnitPrice) AS GrossTotal
FROM Orders o	
	INNER JOIN Order_Details od ON o.OrderID = od.OrderID
	INNER JOIN Customers c ON o.CustomerID = c.CustomerID
WHERE c.CompanyName IN ('B''s Beverages', 'Chop-suey Chinese');
*/

/*
	Find the gross total of all orders (sum of quantity * unit price) 
	for each customer, order it in descending order by the total.

use Northwind;
select c.CompanyName, sum(od.Quantity * od.UnitPrice) as TotalSales
from Customers c
inner join Orders o on c.CustomerID = o.CustomerID
inner join Order_Details od on od.OrderID = o.OrderID
group by c.CompanyName
order by TotalSales desc;

SELECT SUM(Quantity * UnitPrice) AS GrossTotal, CompanyName
FROM Orders o	
	INNER JOIN Order_Details od ON o.OrderID = od.OrderID
	INNER JOIN Customers c ON o.CustomerID = c.CustomerID
GROUP BY CompanyName
ORDER BY GrossTotal DESC;
*/

-- 4
/*
	Get the count of how many employees work for the 
	company

select count(*) from Employees;
*/
-- 5
/*
	Get the count of how many employees 
	report to someone else in the company 
	without using a WHERE clause.

use Northwind;
select count(*) as ManagedEmployees
FROM Employees e1 
	INNER JOIN Employees e2 ON e1.EmployeeID = e2.ReportsTo;
*/
-- 6
/*
	Get the count of how many unique countries
	are represented by our suppliers.
*/
