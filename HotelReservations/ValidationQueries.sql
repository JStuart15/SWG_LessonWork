use HotelReservations;

/* 
    Write a query that returns all the rooms NOT reserved on a particular date
    BONUS: allow me to also specify room type
    Room 7 & 6 reserved for 10/31 to 11/1
    Room 5 reserved for 11/15 to 11/16
    We have 7 rooms; check on 10/31; expect 5 rooms available;
 */
select r.RoomNumber, r.Floor, res.ReservationId, res.StartDate, res.EndDate 
from Room r
left outer join ReservationRoom rr on rr.RoomId = r.RoomId
left outer join Reservation res on res.ReservationId = rr.ReservationId
where 
	res.StartDate is null or
	res.EndDate is null or
	res.StartDate	!= '2017-10-31' and 
	res.EndDate 	!= '2017-10-31'
order by r.RoomId;

/*
	+ Write a query that returns all the rooms reserved for a particular customer
    - Can I identify all info needed to tell a customer their room ...?
    - Even if the hotel had multiple floors? If it was a chain and had multiple hotels?
	- BONUS: instead query based on promotional code
*/
select c.FirstName, c.LastName, l.Name as HotelName, r.Floor, r.RoomNumber, res.StartDate, res.EndDate
from Customer c
inner join Reservation res on res.CustomerId = c.CustomerId
inner join ReservationRoom rr on rr.ReservationId = res.ReservationId
inner join Room r on rr.RoomId = r.RoomId
inner join Location l on l.LocationId = r.LocationId
where c.CustomerId = 1;

/*
	Write a query that returns rooms that contain a set of amenities
	(i.e. list of rooms that have mini-bar, hot-tub and fridge -> (101,207,310,323))

	BONUS: also order by cheapest & not reserved
*/
select rt.Description as RoomType, Room.RoomNumber, Room.Floor, a.Name
from Room
inner join RoomAmenity ra on ra.RoomId = Room.RoomId
inner join Amenity a on ra.AmenityId = a.AmenityId
inner join RoomType rt on rt.RoomTypeId = Room.RoomTypeId
where a.Name in ('Casino');

/*
	+ Write a query that returns a list of reservations that end today
    - add a reservation that ends today
	- BONUS: that also don't have a bill issued
*/
-- drop and insert a reservation that ends today
delete from ReservationRoom where ReservationId = 100;
delete from Reservation where ReservationId = 100;
insert into Reservation (ReservationId, StartDate,EndDate,Bill_BillId,CustomerId) 
values (100, curdate()-1, curdate(), null, 2);

-- insert a matching ReservationRoom entry
insert into ReservationRoom (ReservationId, RoomId)
values (100, 4);

select c.FirstName, c.LastName
from Reservation res
inner join Customer c on c.CustomerId = res.CustomerId
where res.EndDate = curdate();

