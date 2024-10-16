create database if not exists TechShop;
use TechShop;

create table Customers (
    CustomerID int primary key,
    FirstName varchar(50),
    LastName varchar(50),
    Email varchar(100),
    Phone varchar(20),
    Address varchar(255)
);

create table Products(
      ProductId int primary key,
      ProductName varchar(50),
      ProdDescription text,
      Price decimal(10,2)
      );
      
create table Orders(
	OrderId int primary key,
    CustomerId int,
    OrderDate date,
    TotalAmount decimal(10,2),
    foreign key(CustomerId) references Customers(CustomerId)
    );
    
create table OrderDetails (
    OrderDetailID int primary key,
    OrderID int,
    ProductID int,
    Quantity int,
    foreign key (OrderID) references Orders(OrderID),
    foreign key (ProductID) references Products(ProductID)
);

create table Inventory (
    InventoryID int primary key,
    ProductID int,
    QuantityInStock int,
    LastStockUpdate date,
    foreign key (ProductID) references Products(ProductID)
);
desc Inventory;
insert into Customers (CustomerID,FirstName, LastName, Email, Phone, Address) values
(1,'Sri', 'Selvam', 'sri.gmail.com', '1234', 'Chennai,TN'),
(2,'Varsshini', 'Selvam', 'varsshini.com', '5678', 'Chennai,TN'),
(3,'Aruna', 'Nathan', 'aruna.gmail.com', '8765', 'Chennai,TN'),
(4,'Srimathi', 'Srini', 'srimathi.gmail.com', '4321', 'Madurai,TN'),
(5,'Teju', 'Venkat', 'teju.gmail.com', '6789', 'Coimbatore,TN'),
(6,'Suchi', 'Palani', 'suchi.gmail.com', '2345', 'Hyderabad,AP'),
(7,'Sneha', 'Shree', 'sneha.gmail.com', '3456', 'Bangalore,KA'),
(8,'Swetha', 'Muthu', 'swe.gmail.com', '4567', 'Tirussur,KL'),
(9,'Sruthi', 'Ramu', 'sru.gmail.com', '5679', 'Coimbatore,TN'),
(10,'Taylor', 'Swift', 'taylor.gmail.com', '6780', 'NY,USA');

insert into Products (ProductId,ProductName, ProdDescription, Price) values
(1,'Laptop', '8GB RAM, 256GB SSD', 799.99),
(2,'Smartphone', '128GB storage', 499.99),
(3,'Headphones', 'Noise-cancelling headphones', 149.99),
(4,'Keyboard', 'Mechanical keyboard', 89.99),
(5,'Mouse', 'Wireless optical mouse', 29.99),
(6,'Monitor', '27 inch 4K UHD monitor', 349.99),
(7,'Printer', 'All-in-one inkjet printer', 119.99),
(8,'Tablet', '10 inch tablet with 64GB storage', 299.99),
(9,'Smartwatch', 'Fitness tracking smartwatch', 199.99),
(10,'External Hard Drive', '1TB portable external hard drive', 89.99);

insert into Orders (OrderId,CustomerID, OrderDate, TotalAmount) values
(1,1, '2024-09-01', 799.99),
(2,2, '2024-09-02', 499.99),
(3,3, '2024-09-03', 149.99),
(4,4, '2024-09-04', 89.99),
(5,5, '2024-09-05', 29.99),
(6, 6,'2024-09-06', 349.99),
(7, 7,'2024-09-07', 119.99),
(8, 8,'2024-09-08', 299.99),
(9, 9,'2024-09-09', 199.99),
(10,10, '2024-09-10', 89.99);

insert into OrderDetails (OrderDetailID,OrderID, ProductID, Quantity) values
(1,1, 1, 1),
(2,2, 2, 1),
(3, 3,3, 1),
(4, 4,4, 1),
(5, 5,5, 1),
(6, 6,6, 1),
(7, 7,7, 1),
(8, 8,8, 1),
(9, 9,9, 1),
(10, 10,10, 1);

insert into Inventory (InventoryID,ProductID, QuantityInStock, LastStockUpdate) values
(1,1,50,'2024-09-01'),
(2,2, 30,'2024-09-02'),
(3,3, 100,'2024-09-03'),
(4,4, 75,'2024-09-04'),
(5,5, 200,'2024-09-05'),
(6, 6,20,'2024-09-06'),
(7, 7,40,'2024-09-07'),
(8, 8,60,'2024-09-08'),
(9, 9,25,'2024-09-09'),
(10, 10,15,'2024-09-10');

-- task 2 : 
-- 1.retrieve the names and emails of all customers.  
select FirstName, LastName, Email 
from Customers;


-- 2. Write an SQL query to list all orders with their order dates and corresponding customer names. 
select o.OrderId , o.OrderDate, concat(c.FirstName,' ',c.LastName) as CustomerName
from Orders o 
join Customers c 
on o.CustomerID = c.CustomerID;


-- 3. insert a new customer record into the "Customers" table. Include customer information such as name, email, and address.
insert into Customers (CustomerID, FirstName, LastName, Email, Address) 
values (11,'Virat', 'Kohli', 'virat@gmail.com', 'Mumbai,MH');



-- 4. update the prices of all electronic gadgets in the "Products" table by increasing them by 10%. 
set SQL_SAFE_UPDATES = 0;

update Products
set Price = Price * 1.10;



-- 5. delete a specific order and its associated order details from the "Orders" and "OrderDetails" tables. Allow users to input the order ID as a parameter.
delete from OrderDetails where OrderID = 4;

delete from Orders where OrderID = 4;



-- 6. insert a new order into the "Orders" table. Include the customer ID,order date, and any other necessary information. 
insert into Orders (OrderId,CustomerID, OrderDate, TotalAmount) values
(11,11,'2024-06-13',124.50);



-- 7.update the contact information (e.g., email and address) of a specific customer in the "Customers" table. Allow users to input the customer ID and new contact information. 
update Customers
set Email = 'swift@gmail.com', Address = 'LA,USA'
where CustomerID = 10;
 select * from Customers;

 
 -- 8. recalculate and update the total cost of each order in the "Orders" table based on the prices and quantities in the "OrderDetails" table.
-- SUBQUERY
update orders o 
set TotalAmount = (
	select sum(od.Quantity*p.Price)
    from orderDetails od
    join Products p 
    on od.ProductID = p.productID
    where od.OrderId = o.orderId
    );
select * from orders;

-- 9.delete all orders and their associated order details for a specific customer from the "Orders" and "OrderDetails" tables. Allow users to input the customer ID as a parameter. 
delete od from OrderDetails od
join Orders o 
on od.OrderID = o.OrderID
where o.CustomerID = 4;
-- delete from Orders where CustomerID = 4;

select * from Orders;
select * from OrderDetails;
-- delete from Orders where CustomerID = 4;


-- 10. insert a new electronic gadget product into the "Products" table, including product name, category, price, and any other relevant details.
insert into Products (ProductId,ProductName, ProdDescription, Price) values
(11,'Smart Tv','34 inch touch screen', 524.60);


-- 11.  update the status of a specific order in the "Orders" table (e.g., from "Pending" to "Shipped"). Allow users to input the order ID and the new status. 
alter table Orders add column Status varchar(50);
update orders set Status = "Pending";
select * from Orders;

update orders set Status = "Shipped" where OrderID in (3,6,8,1);
select * from Orders;


-- 12. calculate and update the number of orders placed by each customer in the "Customers" table based on the data in the "Orders" table.
-- SUBQUERY

alter table Customers
add OrderCount int default 0;

update Customers c 
set orderCount = (
	select count(*)
    from Orders o
    where o.CustomerId = c.CustomerId
);

-- task 3:
-- 1. retrieve a list of all orders along with customer information (e.g., customer name) for each order.
select * 
from Orders o
join Customers c
on c.CustomerID = o.CustomerID;


-- 2. find the total revenue generated by each electronic gadget product. Include the product name and the total revenue. 
select p.ProductName, sum(od.Quantity * p.Price) as TotalRevenue
from Products p 
join OrderDetails od 
on p.ProductId = od.ProductId
group by p.ProductName;


-- 3. list all customers who have made at least one purchase. Include their names and contact information.
select c.FirstName, c.LastName, c.Address, count(o.OrderId) as Number_Of_Orders
from customers c 
JOIN Orders o 
on c.CustomerId = o.CustomerId
group by c.CustomerId
having Number_Of_Orders >= 1;


-- 4. find the most popular electronic gadget, which is the one with the highest total quantity ordered. Include the product name and the total quantity ordered
update OrderDetails 
set Quantity = 5
where OrderDetailID =2;

select * from OrderDetails;

select p.ProductName, sum(od.Quantity) as TotalQuantityOrdered
from Products p 
JOIN OrderDetails od 
on p.ProductId = od.ProductId
group by p.ProductName
order by TotalQuantityOrdered desc
limit 1;


-- 5. retrieve a list of electronic gadgets along with their corresponding categories.
alter table Products add column Category varchar(50);
update Products set Category = 'Electronics';
select * from Products;

select ProductName, Category
from Products
where Category = 'Electronics';


-- 6. calculate the average order value for each customer. Include the customer's name and their average order value. 
select c.FirstName, c.LastName, avg(o.TotalAmount) as AvgOrderValue
from Customers c
join Orders o 
on c.CustomerID = o.CustomerID
group by c.CustomerID;


-- 7. find the order with the highest total revenue. Include the order ID, customer information, and the total revenue. 
select o.OrderID, c.FirstName, c.LastName,c.Address,c.Email, o.TotalAmount
from Orders o
join Customers c 
on o.CustomerID = c.CustomerID
order by o.TotalAmount desc
limit 1;

 
 -- 8.  list electronic gadgets and the number of times each product has been ordered. 
select p.ProductName, sum(od.Quantity) AS TotalOrdered
from OrderDetails od
join Products p 
on od.ProductID = p.ProductID
group by p.ProductName;


-- 9. find customers who have purchased a specific electronic gadget product. 
select c.FirstName,c.LastName, c.Address 
from Customers c
join Orders o on o.CustomerID = c.CustomerID
join OrderDetails od ON o.OrderID = od.OrderID
join Products p ON od.ProductID = p.ProductID
where p.ProductName = 'Smartphone';


-- 10. calculate the total revenue generated by all orders placed within a specific time period.
select sum(TotalAmount) AS TotalRevenue
from Orders
where OrderDate between '2024-09-03' and '2024-09-10';


-- TASK 4 - SUBQUERIES:
-- 1  find out which customers have not placed any orders. 
select CustomerId, FirstName,LastName 
from Customers 
where CustomerId 
not in ( 
	select CustomerId from Orders
    );


-- 2 find the total number of products available for sale. 
select sum(QuantityInStock) as availProds 
from Inventory 
where ProductId in(
	select ProductId 
    from Products
    );
    
    
-- 3 Write an SQL query to calculate the total revenue generated by TechShop.  
SELECT SUM(TotalAmount) AS TotalRevenue
FROM Orders;


-- 4 Write an SQL query to calculate the average quantity ordered for products in a specific category. 
select avg(od.Quantity)as AvgQuantityOrdered
from OrderDetails od
where od.ProductId in(
	select p.ProductId
    from Products p
    where Category = 'Electronics'
    );


-- 5 Write an SQL query to calculate the total revenue generated by a specific customer.
select SUM(TotalAmount) as TotalRevenue
from Orders
where CustomerID = 2;


-- 6 Write an SQL query to find the customers who have placed the most orders. List their names 
-- and the number of orders they've placed.
select c.CustomerID, c.FirstName, c.LastName, COUNT(o.OrderID) AS NumberOfOrders
from Customers c
join Orders o on c.CustomerID = o.CustomerID
group bY c.CustomerID
order by NumberOfOrders desc;


-- 7 Write an SQL query to find the most popular product category, which is the one with the highest 
-- total quantity ordered across all orders. 
select p.ProductName, SUM(od.Quantity) AS TotalQuantityOrdered
from OrderDetails od
join Products p on od.ProductID = p.ProductID
group by p.ProductID
order by TotalQuantityOrdered desc
limit 1;


-- 8 Write an SQL query to find the customer who has spent the most money (highest total revenue) 
-- on electronic gadgets. List their name and total spending.
select c.customerid, c.firstname,  c.lastname, sum(od.quantity * p.price) as totalspending
from customers c
join orders o on c.customerid = o.customerid
join orderdetails od on o.orderid = od.orderid
join products p on od.productid = p.productid
where p.category = 'electronics'  
group by c.customerid, c.firstname, c.lastname
order by totalspending desc
limit 1;


-- 9 Write an SQL query to calculate the average order value (total revenue divided by the number of 
-- orders) for all customers. 
select avg(TotalAmount) as AverageOrderValue
from Orders;


-- 10 Write an SQL query to find the total number of orders placed by each customer and list their 
-- names along with the order count. 
select c.customerid, c.firstname,  c.lastname, count(o.orderid) as ordercount
from customers c
left join orders o on c.customerid = o.customerid
group by c.customerid
order by ordercount desc;