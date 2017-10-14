use HotelReservations;

/* 
    Write a query that returns all the rooms NOT reserved on a particular date
    
    Room 7 & 6 reserved for 10/31 to 11/1
    Room 5 reserved for 11/15 to 11/16
    We have 8 rooms; check on 10/31; expect 6 rooms available;
    
    BONUS: allow me to also specify room type
 */
select l.Name, r.Floor, r.RoomNumber, rt.Description as RoomType, res.ReservationId, rr.StartDate, rr.EndDate 
from Rooms r
left outer join ReservationsRooms rr on rr.RoomId = r.RoomId
left outer join Reservations res on res.ReservationId = rr.ReservationId
left outer join Locations l on l.LocationId = r.LocationId
left outer join RoomTypes rt on rt.RoomTypeId = r.RoomTypeId
where 
	-- rt.Description = 'Standard' and 
    (rr.StartDate is null or
	rr.EndDate is null) or
	(rr.StartDate	!= '2017-10-31' and 
	rr.EndDate 	!= '2017-10-31')
order by r.RoomId;

/*
	+ Write a query that returns all the rooms reserved for a particular customer
    - Can I identify all info needed to tell a customer their room ...?
    - Even if the hotel had multiple floors? If it was a chain and had multiple hotels?
	- BONUS: instead query based on promotional code
*/
select c.FirstName, c.LastName, l.Name as HotelName, r.Floor, r.RoomId, r.RoomNumber, res.ReservationId, rr.StartDate, rr.EndDate
from Customers c
inner join Reservations res on res.CustomerId = c.CustomerId
inner join ReservationsRooms rr on rr.ReservationId = res.ReservationId
inner join Rooms r on rr.RoomId = r.RoomId
inner join Locations l on l.LocationId = r.LocationId
where c.CustomerId in (1,2,3,4);

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
	- BONUS: that also don't have a bill issued
*/
-- insert a reservation that ends today
insert into Reservations (ReservationId, StartDate,EndDate,Bill_BillId,CustomerId) 
values (100, curdate()-1, curdate(), null, 2),
		(101, curdate()-1, curdate(), null, 3);

-- insert a matching ReservationRoom entry
insert into ReservationsRooms (ReservationId, RoomId)
values (100, 4), (100,3), (101,8);

select c.FirstName, c.LastName, res.ReservationId, res.EndDate, l.Name, r.Floor, r.RoomNumber
from Reservations res
inner join Customers c on c.CustomerId = res.CustomerId
inner join ReservationsRooms rr on rr.ReservationId = res.ReservationId
inner join Rooms r on rr.RoomId = r.RoomId
inner join Locations l on l.LocationId = r.LocationId
where res.EndDate = curdate();

-- delete entries
delete from ReservationRoom where ReservationId in (100,101);
delete from Reservation where ReservationId in (100,101);

/*
  Reservations should list the names and ages of all guests.
*/
select res.ReservationId, l.Name, r.Floor, r.RoomNumber, g.FirstName, g.LastName, g.Age
from Reservations res
inner join ReservationsRooms rr on rr.ReservationId = res.ReservationId
inner join Rooms r on r.RoomId = rr.RoomId
inner join Locations l on l.LocationId = r.LocationId
inner join RoomsGuests rg on rg.RoomId = r.RoomId
inner join Guests g on rg.GuestId = g.GuestId

/*
  - Generate a bill that uses a seasonal rate
  
*/
