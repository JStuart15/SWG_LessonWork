-- Hotel Reservations Summative
-- Jeff Stuart

drop database if exists HotelReservations;
create database if not exists HotelReservations;
use HotelReservations;

-- Location Table
create table if not exists Location(
	LocationId int not null primary key auto_increment,
    Name varchar(45) not null,
    StreetAddr varchar(45) not null,
    City varchar(45) not null,
    State varchar(45) not null,
    Zip char(10) not null
);
insert into Location (Name, StreetAddr, City, State, Zip) 
	values 	('Stratosphere', '123 Main Street', 'Las Vegas', 'NV', '85560'),
			('The Grand', '345 Main Street', 'Atlantic City', 'NJ', '11034');

-- Amenity Table
create table if not exists Amenity(
	AmenityId int not null primary key auto_increment,
    Name varchar(45) not null
);
insert into Amenity (Name) values ('Casino'), ('Refrigerator'), ('Mini-Bar'), ('Air conditioning'), ('Jacuzzi'),('Master Suite');

-- Room Type Table
create table if not exists RoomType(
	RoomTypeId int not null primary key auto_increment,
    Name varchar(45) not null,
    BaseRate decimal not null
);
insert into RoomType (Name, BaseRate) values ('Standard', 32), ('Premier', 36), ('Select', 44), ('Elite', 56);

-- Room Table
create table if not exists Room(
	RoomId int not null primary key auto_increment,
    RoomTypeId int not null,
	foreign key (RoomTypeId) references RoomType(RoomTypeId),
    LocationId int not null,
    foreign key (LocationId) references Location(LocationId),
    RoomNumber int not null,
    Floor varchar(30) not null,
    OccupancyLimit int not null
);
insert into Room (RoomTypeId, LocationId, RoomNumber, Floor, OccupancyLimit) values (1, 1, 1, 1, 4), (1, 1, 1, 2, 4), (1, 1, 1, 3, 4), (2, 1, 1, 4, 4), (2, 1, 2, 4, 4), (2, 1, 3, 4, 4);

-- RoomAmenity Table
create table if not exists RoomAmenity(
	RoomId int not null,
    foreign key (RoomId) references Room(RoomId),
    AmenityId int not null,
    foreign key (AmenityId) references Amenity(AmenityId),
    primary key (RoomId, AmenityId)
);
insert into RoomAmenity (RoomId, AmenityId) 
values 	(1,1), (2,1), (3,1), (4,1), # every room has Casino
			   (2,2), (3,2), (4,2), # only some rooms have refrigerator
					  (3,3), (4,3), # only some rooms have Minibar
		(1,4), (2,4), (3,4), (4,4), # all rooms have AC
							 (4,5), #only Elite has Jacuzzi
					  (3,6), (4,6); #only Select/Elite have separate master bedrooms

-- customer table
create table if not exists Customer(
	CustomerId int not null primary key auto_increment,
    FirstName varchar(45) not null,
    LastName varchar(45) not null,
    Phone char(12) null,
    Email varchar(60) not null
);
insert into Customer (FirstName, LastName, Phone, Email)
values ('Corbin', 'March', '', 'cmarch@sg.com'), ('Kyle', 'Rudy', '', 'krudy@sg.com'), ('Eric', 'Wise', '', 'ewise@sg.com');

use HotelReservations;
select * from Amenity;
select * from Customer;