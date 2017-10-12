drop database if exists SGRoster;
create database SGRoster;
use SGRoster;

create table Cohort if not exists(
	CohortId int not null auto_increment,
    StartDate date not null,
    Subject varchar(30) not null,
    Location varchar(30) not null,
    primary key(CohortId)
);

create table Apprentice(
	ApprenticeId int not null auto_increment,
    FirstName varchar(30) not null,
    LastName varchar(30) not null,
    primary key (ApprenticeId)
);

/*
create table Apprentice(
	ApprenticeId int not null auto_increment,
    FirstName varchar(30) not null,
    LastName varchar(30) not null,
    CohortId int not null,
    primary key (ApprenticeId),
    foreign key (CohortId) references Cohort(CohortId)
);

alter table Apprentice
drop foreign key Apprentice_ibfk_1;

alter table Apprentice
drop column CohortId;

drop table Apprentice; 
*/

create table ApprenticeCohort(
	ApprenticeId int not null,
    CohortId int not null,
    primary key (ApprenticeId, CohortId)
);

alter table ApprenticeCohort
add constraint fk_ApprenticeCohort_Apprentice
foreign key (ApprenticeId) references Apprentice(ApprenticeId);

alter table ApprenticeCohort
add constraint fk_ApprenticeCohort_Cohort
foreign key (CohortId) references Cohort(CohortId);

alter table Apprentice
add DateOfBirth date not null;

alter table Apprentice
modify column DateOfBirth datetime null;

#drop database SGRoster;

insert into Apprentice(FirstName, LastName)
values ('Bob', 'Jones'), ('Bob', 'Smith'), ('Brenda', 'Walters'), ('Shauna', 'Mullins');

insert into Cohort (StartDate, Subject, Location)
values('2017/1/9', 'C#', 'Akron'), ('2017/1/9', 'Java', 'Akron');

insert into ApprenticeCohort(ApprenticeId, CohortId)
values (1,1), (2,1), (3,2), (4,2);

update ApprenticeCohort
set CohortId =2
where ApprenticeId=2;

update ApprenticeCohort
set CohortId = 1
where ApprenticeId in (3,4);

update ApprenticeCohort
set CohortId = 1
where CohortId = 2;

delete from Cohort
where CohortId=2;

