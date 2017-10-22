use SuperPeopleSightings;

select * from super_people_organizations;
select * from organizations;
select * from super_people;
select * from locations;
select * from super_powers;
select * from sightings;
select * from super_people_sightings;

delete from locations where location_id = 2;

select orgs.*
from organizations orgs
inner join super_people_organizations spo on spo.organization_id = orgs.organization_id
where spo.super_person_id in (19);

select sp.*
from super_people sp
inner join super_people_sightings sps on sps.super_person_id = sp.super_person_id
where sps.sighting_id = 1;

select sp.*
from super_powers sp
inner join super_people speople on speople.super_power_id = sp.super_power_id
where speople.super_person_id = 1;

-- The system must be able to report all of the superheroes sighted at a particular location.
select distinct s.super_person_id
from super_people s
inner join super_people_sightings sps on sps.super_person_id = s.super_person_id
inner join sightings on sightings.sighting_id = sps.sighting_id
inner join locations l on l.location_id = sightings.location_id
where l.location_id = 6;

-- The system must be able to report all of the locations where a particular superhero has been seen.
select l.location_id
from locations l
inner join sightings s on s.location_id = l.location_id
inner join super_people_sightings sps on sps.sighting_id = s.sighting_id
inner join super_people sp on sps.super_person_id = sp.super_person_id
where sp.super_person_id = 1;

-- The system must be able to report all sightings (hero and location) for a particular date.
select s.sighting_id 
from sightings s
where s.date = '2017-10-21';

-- The system must be able to report all of the members of a particular organization.
select sp.super_person_id
from super_people sp
inner join super_people_organizations spo on spo.super_person_id = sp.super_person_id
inner join organizations o on o.organization_id = spo.organization_id
where o.organization_id = 50;

-- The system must be able to report all of the organizations a particular superhero/villain belongs to.
select o.organization_id
from organizations o
inner join super_people_organizations spo on spo.organization_id = o.organization_id
inner join super_people sp on sp.super_person_id = spo.super_person_id
where sp.super_person_id = 124;
