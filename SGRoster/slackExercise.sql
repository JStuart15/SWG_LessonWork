drop database if exists slack;
create database slack;
use slack;

create table `Channel` (
	ChannelId int primary key auto_increment,
    `Name` varchar(255) not null,
    DateCreated datetime,
    DateModified datetime
);

insert into `Channel`(`Name`, DateCreated) 
	values('OOPJava', NOW()), ('Mpls-2017-08-21', NOW());
    
create table User (
	UserId int primary key auto_increment,
    FirstName varchar(255) not null,
    LastName varchar(255),
    DateCreated datetime,
    DateModified datetime
);

create table UserChannel (
    UserId int not null,
    ChannelId int not null,
    foreign key (UserId) references User(UserId),
    foreign key (ChannelId) references Channel(ChannelId),
    primary key (UserId, ChannelId)
);

insert into User(FirstName, LastName, DateCreated)
	values ('Alejandro', 'Guzman', now()),
    ('Pat', 'Haug', now()),
	('Rithee', '', now());

insert into UserChannel (UserId, ChannelId)
	values (1, 1),(2, 1),(3, 1),(1, 2),(2, 2),(3, 2);
    
create table Message (
	MessageId int primary key auto_increment,
    Message varchar(255) not null,
    UserId int,
    ChannelId int,
    DateCreated datetime,
    DateModified datetime,
	foreign key (UserId) references User(UserId),
    foreign key (ChannelId) references `Channel`(ChannelId)
);

insert into Message(Message, UserId, ChannelId, DateCreated) 
	values('Does anyone know how to do these scripts?', 1, 1, now()),
    ('Look at the lessons.', 2, 1, now()),    
	('I did, lesson 7 isn''t clear', 1, 1, now()), 
	('Which part of the lesson?', 2, 1, now()),
	('I had the same problem, anyone solve it?', 3, 1, now());