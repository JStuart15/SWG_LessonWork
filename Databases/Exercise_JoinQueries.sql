/*
	Get a list of each employee first name and lastname
	and the territory names they are associated with

USE Northwind;
select e.FirstName, e.LastName, t.TerritoryDescription
from Employees e
inner join EmployeeTerritories et on et.EmployeeID = e.EmployeeID
inner join Territories t on et.TerritoryID = t.TerritoryID;
*/

/*
	Get the Company Name, Order Date, and each order details 
	Product name for USA customers only.

USE Northwind;
select c.CompanyName, o.OrderDate, p.ProductName
from Orders o
inner join Customers c on o.CustomerID = c.CustomerID
inner join Order_Details od on o.OrderID = od.OrderID
inner join Products p on p.ProductID = od.ProductID
where c.Country = 'USA';

SELECT c.CompanyName, o.OrderDate, p.ProductName
FROM Customers c
	INNER JOIN Orders o ON c.CustomerID = o.CustomerID
	INNER JOIN Order_Details od ON o.OrderID = od.OrderID
	INNER JOIN Products p ON od.ProductID = p.ProductID
WHERE c.Country = 'USA';
*/

/*
	Get all the order information for any order where Chai was sold.
    
USE Northwind;
select *
from Orders o 
	inner join Order_Details od on od.OrderID = o.OrderID
	inner join Products p on p.ProductID = od.ProductID
where p.ProductName = 'Chai';

SELECT o.*
FROM Products p
	INNER JOIN Order_Details od ON od.ProductID = p.ProductID
	INNER JOIN Orders o ON o.OrderID = od.OrderID
WHERE p.ProductName = 'Chai';
*/

/*
	Write a query to show every combination of employee and location.

USE SWCCorp;
select e.FirstName, e.LastName, l.City
from Employee e
cross join Location l;
*/

/*
	Find a list of all the Employees who have never found a Grant
    
USE SWCCorp;
select e.FirstName, e.LastName, g.GrantName
from Employee e
left outer join `Grant` g on g.EmpID = e.EmpID
where g.GrantId is null;
*/
