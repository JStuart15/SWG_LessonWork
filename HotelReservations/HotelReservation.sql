drop database if exists HotelReservation;
create database if not exists HotelReservation;
use HotelReservation;

create table if not exists Amenity(
	AmenityId int not null primary key auto_increment,
    Name varchar(45) not null
);
insert into Amenity (Name) values ('Casino'), ('Full-service spa'), ('Outdoor pool'), ('Air conditioning'), ('Fitness center'),('Daily housekeeping');
        
create table if not exists Room(
	RoomId int not null primary key auto_increment,
	foreign key (RoomTypeId) references RoomType(RoomTypeId),
    RoomNumber int not null,
    Floor varchar(30) not null,
    OccupancyLimit int not null
);
