drop database if exists OMDB;
create database OMDB;
use OMDB;
create table Movie (
	MovieId int primary key auto_increment,
    Title varchar(255) not null,
    Studio varchar(255) null,
    ReleaseDate date null,
    DateCreated datetime,
    DateModified datetime
);

create table Person(
	PersonId int primary key auto_increment,
    FirstName varchar(255) not null,
    LastName varchar(255) null,
    DateCreated datetime,
    DateModified datetime
);

create table Role (
	RoleId int primary key auto_increment,
    `Name` varchar(255) not null
);

create table MoviePersonRole(
	MovieId int not null,
    PersonId int not null,
    RoleId int not null,
    foreign key (MovieId) references Movie(MovieId),
    foreign key (PersonId) references Person(PersonId),
    foreign key (RoleId) references Role(RoleId),
    primary key (MovieId, PersonId, RoleId)
);

insert into Role (`Name`) values ('Actor');
insert into Role (`Name`) values ('Director');
insert into Role (`Name`) values ('Producer');
insert into Role (`Name`) values ('Executive Producer');
insert into Role (`Name`) values ('Writer');

insert into Movie (Title) values ('Jurassic Park');
insert into Movie (Title, Studio) values ('Star Wars', 'Lucas Films');
insert into Movie (Title) values ('Pee Wee''s Big Adventure');

insert into Person (FirstName) values ('Cher');
insert into Person (FirstName, LastName) values ('Jeff', 'Goldblum');
insert into Person (FirstName, LastName) values ('Mark', 'Hamil');

insert into MoviePersonRole (MovieId, PersonId, RoleId)
values (1, 2, 3);

insert into MoviePersonRole (MovieId, PersonId, RoleId)
values (1, 2, 5);

update MoviePersonRole set
	RoleId = 1
where MovieId = 1 
and PersonId = 2
and RoleId = 3;

delete from MoviePersonRole
	where MovieId = 1
    and PersonId = 2
    and RoleId in (3,4,5);
    
    use OMDB;
#joining tables allows us to get at the things we need

select
	Movie.Title, Person.FirstName, Person.LastName
from Movie
inner join MoviePersonRole 
	on Movie.MovieId = MoviePersonRole.MovieId
inner join Person
	on MoviePersonRole.PersonId = Person.PersonId;
    
update Movie set
	ReleaseDate = '1983-05-25'
where MovieId = 2;