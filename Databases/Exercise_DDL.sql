create database if not exists MovieCatalogue;

use MovieCatalogue;

create table if not exists Genre(
	GenreId int not null primary key auto_increment,
    GenreName varchar(30) not null
);

create table if not exists Rating(
	RatingId int not null primary key auto_increment,
    RatingName char(5) not null
);

create table if not exists Director(
	DirectorId int not null primary key auto_increment,
    FirstName varchar(30) not null,
    LastName varchar(30) not null,
    BirthDate date null
);

create table if not exists Actor(
	ActorId int not null primary key auto_increment,
    FirstName varchar(30) not null,
    LastName varchar(30) not null,
    BirthDate date null
);

create table if not exists Movie(
	MovieId int not null primary key auto_increment,
    DirectorId int not null,
    GenreId int not null,
    RatingId int not null,
    foreign key (DirectorId) references Director(DirectorId),
	foreign key (GenreId) references Genre(GenreId),
    foreign key (RatingId) references Rating(RatingId),
    Title varchar(128) not null,
    ReleaseDate date null
    );

create table if not exists CastMember(
	CastMemberId int not null primary key auto_increment,
    ActorId int not null,
    MovieId int not null,
    foreign key (ActorId) references Actor(ActorId),
    foreign key (MovieId) references Movie(MovieId),
    Role varchar(50) not null
);
/*
alter table Movie
	add constraint `fk_MovieGenre` foreign key (GenreId)
		references Genre(GenreId) on delete no action;

alter table Movie
	add constraint `fk_MovieDirector` foreign key (DirectorId)
		references Director(DirectorId) on delete no action;
        
ALTER TABLE Movie
	ADD CONSTRAINT `fk_MovieRating` FOREIGN KEY (RatingID) 
		REFERENCES `Rating`(`RatingID`) ON DELETE NO ACTION;

ALTER TABLE CastMember 
	ADD CONSTRAINT `fkCastMemberActor` FOREIGN KEY (ActorID) 
		REFERENCES Actor(ActorID) ON DELETE NO ACTION;
        
ALTER TABLE CastMember 
	ADD CONSTRAINT `fkCastMemberMovie` FOREIGN KEY (MovieID) 
		REFERENCES Movie(MovieID) ON DELETE NO ACTION;
*/