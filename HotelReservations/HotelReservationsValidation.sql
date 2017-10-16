use HotelReservations;

/* 1
    + Write a query that returns all the rooms NOT reserved on a particular date
    + RoomIds 6 & 7 are reserved on 10/31 by Kyle
    - BONUS: allow me to also specify room type
 */
select l.Name, r.Floor, r.RoomId, r.RoomNumber, rt.Description as RoomType, res.ReservationId, rr.StartDate, rr.EndDate 
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

/* 2
	+ Write a query that returns all the rooms reserved for a particular customer
    + Can I identify all info needed to tell a customer their room ...?
		+ Even if the hotel had multiple floors? If it was a chain and had multiple hotels?
    + Can a wedding party have many rooms on the same reservations? Yes
		+ Do they all have to arrive and leave on the same day? No
	- BONUS: instead query based on promotional code
*/
select c.FirstName, c.LastName, l.Name as Hotel, r.RoomId, r.Floor, r.RoomNumber, r.RoomId, res.ReservationId, rr.StartDate, rr.EndDate
from Customers c
inner join Reservations res on res.CustomerId = c.CustomerId
inner join ReservationsRooms rr on rr.ReservationId = res.ReservationId
inner join Rooms r on rr.RoomId = r.RoomId
inner join Locations l on l.LocationId = r.LocationId
where c.CustomerId in (1,2,3,4);

/* 3
	+ Write a query that returns rooms that contain a set of amenities
	+ (i.e. list of rooms that have mini-bar, hot-tub and fridge -> (101,207,310,323))
	+ Can I track 2 HD tvs in a room, or other multiple amenities? Can the room TYPE change?
	- BONUS: also order by cheapest & not reserved
*/
select l.Name as Hotel, r.Floor, r.RoomNumber, rt.Description as RoomType,  a.Name as AmenityRoomAmenity, ra.Quantity
from Rooms r
inner join RoomsAmenities ra on ra.RoomId = r.RoomId
inner join Amenities a on ra.AmenityId = a.AmenityId
inner join RoomTypes rt on rt.RoomTypeId = r.RoomTypeId
inner join Locations l on l.LocationId = r.LocationId
-- where a.Name = 'HD TV' and a.Name = 'Jacuzzi'
where a.Name in ('HD TV', 'Jacuzzi')
order by r.RoomId;

select ra.RoomId, count(*) 
from RoomsAmenities ra
where ra.AmenityId in (5,7)
group by ra.RoomId
having count(*) = 2;

/* 4
	+ Write a query that returns a list of reservations that end on a specified date
	- BONUS: that also don't have a bill issued
*/
select c.FirstName, c.LastName, res.ReservationId, rr.EndDate, l.Name, r.Floor, r.RoomNumber
from Reservations res
inner join Customers c on c.CustomerId = res.CustomerId
inner join ReservationsRooms rr on rr.ReservationId = res.ReservationId
inner join Rooms r on rr.RoomId = r.RoomId
inner join Locations l on l.LocationId = r.LocationId
where rr.EndDate = '2017-10-16' -- and res.InvoiceId is null
;

/* 5
	+ Write a query that returns a list of promotion codes, and the #times used.
	+ bonus: allow me to specify a date range
*/
select p.PromoCode as Promotion, count(r.ReservationId) as `Times Used`
from Promotions p 
left outer join ReservationsPromotions rp on rp.PromotionId = p.PromotionId
left outer join Reservations r on r.ReservationId = rp.ReservationId
where p.StartDate between '2017/01/01' and '2017/12/31' 
group by p.PromoCode;

/* 6
	- Write a query that returns the 10 most expensive bills ever charged
	- bonus: allow me to specify a customer
    - make up some past stays
*/

/* 7
  Reservations should list the names and ages of all guests.
*/
select res.ReservationId, rr.RoomId, rr.StartDate, rr.EndDate, g.FirstName, g.LastName, g.Age
from Reservations res
inner join ReservationsRooms rr on rr.ReservationId = res.ReservationId
inner join ReservationsRoomsGuests rrg on rr.ReservationId = rrg.ReservationId and rr.RoomId = rrg.RoomId
inner join Guests g on rrg.GuestId = g.GuestId
order by res.ReservationId, rr.RoomId;

/*
	- Generate invoice(s) by reservation number
*/
-- 8a Generate Invoice Header
-- add in promotions
select i.InvoiceId, c.FirstName, c.LastName, 
	round((i.Total + i.TotalTax) * (1 - IFNULL(p.DiscountPercent, p.DiscountFlat)/100),2) as Total 
from Reservations res
inner join Customers c on c.CustomerId = res.CustomerId
inner join Invoices i on i.CustomerId = c.CustomerId
inner join ReservationsPromotions rp on res.ReservationId = rp.ReservationId
inner join Promotions p on p.PromotionId = rp.PromotionId
where res.ReservationId = 4;

-- 8b Generate Invoice Lines
select rr.RoomId, id.InvoiceId, id.Description, id.ChargeDate, id.UnitPrice, 
	id.Quantity, id.Discount, round((id.UnitPrice*id.Quantity*(1 + Discount/100)),2) as Total
from Reservations res
inner join Customers c on c.CustomerId = res.CustomerId
inner join Invoices i on i.CustomerId = c.CustomerId
inner join InvoiceDetails id on id.InvoiceId = i.InvoiceId
inner join ReservationsRooms rr on rr.InvoiceId = i.InvoiceId
where res.ReservationId = 4
order by rr.RoomId, id.ChargeDate;

/*
	- Generate invoice(s) by room number
*/
-- 9a Generate Header information
select 	i.InvoiceId, 
		concat(c.FirstName, " ", c.LastName) as Customer, 
		round((i.Total + i.TotalTax) * (1 - IFNULL(p.DiscountPercent, p.DiscountFlat)/100),2) as Total 
from Reservations res
inner join Customers c on c.CustomerId = res.CustomerId
inner join Invoices i on i.CustomerId = c.CustomerId
inner join ReservationsPromotions rp on res.ReservationId = rp.ReservationId
inner join Promotions p on p.PromotionId = rp.PromotionId
inner join ReservationsRooms rr on rr.ReservationId = res.ReservationId
where rr.RoomId in (5, 6);

-- if I can get header, I can get lines, no need to repeat

/*
	- Generate invoice(s) by customer
*/
-- 10a Generate Header information
select 	i.InvoiceId, 
		concat(c.FirstName, " ", c.LastName) as Customer, 
		round((i.Total + i.TotalTax) * (1 - IFNULL(p.DiscountPercent, p.DiscountFlat)/100),2) as Total 
from Reservations res
inner join Customers c on c.CustomerId = res.CustomerId
inner join Invoices i on i.CustomerId = c.CustomerId
inner join ReservationsPromotions rp on res.ReservationId = rp.ReservationId
inner join Promotions p on p.PromotionId = rp.PromotionId
where c.FirstName in ('Jeff');
-- if I can get header, I can get lines, no need to repeat
