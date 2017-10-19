drop database if exists VendingMachine;
create database if not exists VendingMachine;

use VendingMachine;
create table if not exists Items(
 ItemId int not null primary key auto_increment,
 ItemName varchar(25) not null,
 ItemCost decimal(3,2) not null,
 Quantity int
);

insert into Items (ItemId, ItemName, ItemCost, Quantity)
values (1, 'Snickers', 1.85, 9),
		(2, 'M&Ms', 1.50, 2),
        (3, 'Almond Joy', 2.10, 5),
        (4, 'Reese''s', 1.85, 4),
        (5, 'Milky Way', 1.25, 9),
        (6, 'Payday', 1.95, 3),
        (7, 'Doritos', 1.75, 11),
        (8, 'Pringles', 1.85, 0),
        (9, 'Cheezits', 1.95, 6);
        
drop database if exists VendingMachineTest;
create database if not exists VendingMachineTest;

use VendingMachineTest;
create table if not exists Items(
 ItemId int not null primary key auto_increment,
 ItemName varchar(25) not null,
 ItemCost decimal(3,2) not null,
 Quantity int
);

insert into Items (ItemId, ItemName, ItemCost, Quantity)
values (1, 'Snickers', 1.85, 9),
		(2, 'M&Ms', 1.50, 2),
        (3, 'Almond Joy', 2.10, 5),
        (4, 'Reese''s', 1.85, 4),
        (5, 'Milky Way', 1.25, 9),
        (6, 'Payday', 1.95, 3),
        (7, 'Doritos', 1.75, 11),
        (8, 'Pringles', 1.85, 0),
        (9, 'Cheezits', 1.95, 6);        
        
use VendingMachineTest;
select * from Items;        

use VendingMachine;
select * from Items;  