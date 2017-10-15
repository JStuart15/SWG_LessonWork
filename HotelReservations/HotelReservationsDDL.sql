-- Hotel Reservations Summative
-- Jeff Stuart

drop database if exists HotelReservations;
create database if not exists HotelReservations;
use HotelReservations;

-- Locations Table
create table if not exists Locations(
	LocationId int not null primary key auto_increment,
    Name varchar(45) not null,
    StreetAddr varchar(45) not null,
    City varchar(45) not null,
    State char(2) not null,
    Zip char(10) not null
);

-- Amenities Table
create table if not exists Amenities(
	AmenityId int not null primary key auto_increment,
    Name varchar(45) not null
);

-- RoomTypes Table
create table if not exists RoomTypes(
	RoomTypeId int not null primary key auto_increment,
    Description varchar(45) not null,
    BaseRate decimal not null
);

-- Rooms Table
create table if not exists Rooms(
	RoomId int not null primary key auto_increment,
    RoomTypeId int not null,
    LocationId int not null,
    RoomNumber int not null,
    Floor varchar(30) not null,
    OccupancyLimit int not null,
	foreign key (RoomTypeId) references RoomTypes(RoomTypeId),
    foreign key (LocationId) references Locations(LocationId)
);

-- RoomAmenity Table
create table if not exists RoomAmenities(
	RoomId int not null auto_increment,
    AmenityId int not null,
    Quantity int not null,
    primary key (RoomId, AmenityId),
    foreign key (AmenityId) references Amenities(AmenityId),
	foreign key (RoomId) references Rooms(RoomId)
);

-- Customers table
create table if not exists Customers(
	CustomerId int not null primary key auto_increment,
    FirstName varchar(45) not null,
    LastName varchar(45) not null,
    Phone char(12) null,
    Email varchar(60) not null
);

-- ReservationStatuses table
create table if not exists ReservationStatuses(
	StatusId int not null primary key auto_increment,
    StatusName varchar(45) not null
);

-- Reservations table
create table if not exists Reservations(
	ReservationId int not null primary key auto_increment,
    CustomerId int not null,
    StatusId int not null default 1,
    foreign key (StatusId) references ReservationStatuses(StatusId),
    foreign key (CustomerId) references Customers(CustomerId)
);

-- InvoiceStatuses table
create table if not exists InvoiceStatuses(
	StatusId int not null primary key auto_increment,
    StatusName varchar(45) not null
);

-- Guests table
create table if not exists Guests(
	GuestId int not null primary key auto_increment,
    FirstName varchar(45) not null,
    LastName varchar(45) not null,
    Age int null
);

-- Invoices table
create table if not exists Invoices(
	InvoiceId int not null primary key auto_increment,
    CustomerId int not null,
    Total decimal null default 0,
    TotalTax decimal null default 0,
    StatusId int not null,
    foreign key (CustomerId) references Customers(CustomerId),
    foreign key (StatusId) references InvoiceStatuses(StatusId)
);

-- ReservationsRooms table
create table if not exists ReservationsRooms(
	ReservationId int not null,
    RoomId int not null,
    InvoiceId int not null,
    StartDate date not null,
    EndDate date not null,
    primary key (ReservationId, RoomId, InvoiceId),
    foreign key (ReservationId) references Reservations(ReservationId),
    foreign key (RoomId) references Rooms(RoomId),
    foreign key (InvoiceId) references Invoices(InvoiceId)
);

-- RoomRates table 
create table if not exists RoomRates(
	RateId int not null primary key auto_increment,
    LocationId int not null,
    RoomTypeId int not null,
    StartDate date not null,
    EndDate date not null,
    Rate decimal not null,
    foreign key (LocationId) references Locations(LocationId),
    foreign key (RoomTypeId) references RoomTypes(RoomTypeId)
);

-- AddOns table
create table if not exists AddOns(
	AddOnId int not null primary key auto_increment,
    StartDate date not null,
    EndDate date not null,
    UnitPrice decimal not null,
    Description varchar(45) not null,
);