drop database if exists dvdlibrary;
create database if not exists dvdlibrary;

use dvdlibrary;
create table if not exists dvds(
 dvd_id int not null primary key auto_increment,
 title varchar(25) not null,
 release_year int(4) not null,
 director varchar(25) not null,
 rating char(5) not null,
 notes mediumtext null
);

drop database if exists dvdlibrary_test;
create database if not exists dvdlibrary_test;

use dvdlibrary_test;
create table if not exists dvds(
 dvd_id int not null primary key auto_increment,
 title varchar(25) not null,
 release_year int(4) not null,
 director varchar(25) not null,
 rating char(5) not null,
 notes mediumtext null
);