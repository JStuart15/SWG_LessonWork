USE Northwind;
/*
SELECT CustomerID, OrderDate, LastName
FROM Orders        
LEFT JOIN Employees ON Orders.EmployeeID = Employees.EmployeeID
WHERE LastName is null;

select CompanyName, City, Country
  from Customers
  where CompanyName regexp '^[A-B][^N-Z].*' 
  order by CompanyName;
  
  
select  FirstName, LastName, BirthDate
from Employees
where YEAR(BirthDate) between 1940 and 1960
order by LastName desc

select *
from Customers
order by ContactTitle desc, CompanyName;
*/
/* select CategoryName, ProductName, UnitPrice, UnitsInStock
from Categories
inner join Products on Categories.CategoryID = Products.CategoryID
order by Categoryname, UnitPrice desc;
*/
/*
select CategoryName, ProductName, UnitPrice, UnitsInStock
from Categories
inner join Products on Categories.CategoryID = Products.CategoryID
where CategoryName = 'Confections'
order by UnitPrice desc
limit 0,6;
*/
/*
select count(*) from Products
where UnitPrice > 20;
*/
/*
select CategoryName, count(*) as NumProducts
from Products p
inner join Categories c on p.CategoryID = c.CategoryID
group by CategoryName;
*/
/*
select sum(od.UnitPrice * od.Quantity) as total, country
from Orders o
inner join Order_Details od on o.OrderID = od.OrderID
inner join Customers c on c.CustomerID = o.CustomerID
where OrderDate between '1996/1/1' and '1996/12/31'
group by Country
order by Total desc;
*/
/*
select FirstName, LastName, Sum(UnitPrice * Quantity) as TotalSales
from Orders o
inner join Order_Details od on o.OrderID = od.OrderID
inner join Employees e on o.EmployeeID = e.EmployeeID
group by FirstName, LastName
having sum(UnitPrice * Quantity) > 200000
order by TotalSales desc;
*/
/*
SELECT Country, SUM(UnitPrice * Quantity) AS TotalSales, 
MIN(UnitPrice * Quantity) AS SmallestOrder,
MAX(UnitPrice * Quantity) AS LargestOrder,      
AVG(UnitPrice * Quantity) AS AverageOrder,
COUNT(o.OrderID) AS TotalOrders
FROM Orders o 
INNER JOIN Order_Details od ON o.OrderID = od.OrderID        
INNER JOIN Customers c ON o.CustomerID = c.CustomerID
GROUP BY Country
ORDER BY TotalSales DESC;
*/
/*
select distinct Country 
from Customers
order by Country;
*/

SELECT DISTINCT(o.OrderID), OrderDate, CompanyName
FROM Orders o 
INNER JOIN Customers c ON o.CustomerID = c.CustomerID
INNER JOIN Order_Details od ON o.OrderID = od.OrderID
WHERE od.ProductID IN     
-- subquery      
   (SELECT ProductID        
   FROM Products
   WHERE  UnitPrice > 90.00       
   ORDER BY UnitPrice DESC)
ORDER BY CompanyName, OrderID;

SELECT DISTINCT(o.OrderID), OrderDate, CompanyName
FROM Orders o 
INNER JOIN Customers c ON o.CustomerID = c.CustomerID
INNER JOIN Order_Details od ON o.OrderID = od.OrderID
INNER JOIN
   (SELECT ProductID  
   FROM Products
   WHERE UnitPrice > 90.00                    
   ORDER BY UnitPrice DESC) 
AS TopProducts                
ON od.ProductID = TopProducts.ProductID
ORDER BY CompanyName, OrderID;

SELECT o.OrderID, o.OrderDate,    
   (SELECT MAX(od.UnitPrice)     
   FROM Order_Details od
   WHERE o.OrderID = od.OrderID) 
AS MaxUnitPrice
FROM Orders o;