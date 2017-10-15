-- -----------------------------------------------------
-- Data for table `HotelReservations`.`Locations`
-- -----------------------------------------------------
START TRANSACTION;
USE `HotelReservations`;
INSERT INTO `HotelReservations`.`Locations` (`LocationId`, `Name`, `StreetAddr`, `City`, `State`, `Zip`) VALUES (1, 'Stratosphere', '123 Main Street', 'Las Vegas', 'NV', '85560');
INSERT INTO `HotelReservations`.`Locations` (`LocationId`, `Name`, `StreetAddr`, `City`, `State`, `Zip`) VALUES (2, 'The Grand', '345 Main Street', 'Atlantic City', 'NJ', '11034');

COMMIT;


-- -----------------------------------------------------
-- Data for table `HotelReservations`.`RoomRates`
-- -----------------------------------------------------
START TRANSACTION;
USE `HotelReservations`;
INSERT INTO `HotelReservations`.`RoomRates` (`RateId`, `LocationId`, `StartDate`, `EndDate`, `Rate`) VALUES (1, 1, '2017/10/31', '2017/11/01', 50);
INSERT INTO `HotelReservations`.`RoomRates` (`RateId`, `LocationId`, `StartDate`, `EndDate`, `Rate`) VALUES (2, 1, '2017/10/31', '2017/11/01', 75);
INSERT INTO `HotelReservations`.`RoomRates` (`RateId`, `LocationId`, `StartDate`, `EndDate`, `Rate`) VALUES (3, 1, '2017/10/31', '2017/11/01', 100);
INSERT INTO `HotelReservations`.`RoomRates` (`RateId`, `LocationId`, `StartDate`, `EndDate`, `Rate`) VALUES (4, 1, '2017/10/31', '2017/11/01', 125);

COMMIT;


-- -----------------------------------------------------
-- Data for table `HotelReservations`.`RoomTypes`
-- -----------------------------------------------------
START TRANSACTION;
USE `HotelReservations`;
INSERT INTO `HotelReservations`.`RoomTypes` (`RoomTypeId`, `Description`, `BaseRate`, `RateId`) VALUES (1, 'Standard', 32, NULL);
INSERT INTO `HotelReservations`.`RoomTypes` (`RoomTypeId`, `Description`, `BaseRate`, `RateId`) VALUES (2, 'Premier', 36, NULL);
INSERT INTO `HotelReservations`.`RoomTypes` (`RoomTypeId`, `Description`, `BaseRate`, `RateId`) VALUES (3, 'Select', 44, NULL);
INSERT INTO `HotelReservations`.`RoomTypes` (`RoomTypeId`, `Description`, `BaseRate`, `RateId`) VALUES (4, 'Elite', 56, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `HotelReservations`.`Rooms`
-- -----------------------------------------------------
START TRANSACTION;
USE `HotelReservations`;
INSERT INTO `HotelReservations`.`Rooms` (`RoomId`, `LocationId`, `RoomNumber`, `Floor`, `OccupancyLimit`, `RoomTypeId`) VALUES (1, 1, 1, '1', 4, 1);
INSERT INTO `HotelReservations`.`Rooms` (`RoomId`, `LocationId`, `RoomNumber`, `Floor`, `OccupancyLimit`, `RoomTypeId`) VALUES (2, 1, 1, '2', 4, 1);
INSERT INTO `HotelReservations`.`Rooms` (`RoomId`, `LocationId`, `RoomNumber`, `Floor`, `OccupancyLimit`, `RoomTypeId`) VALUES (3, 1, 1, '3', 4, 2);
INSERT INTO `HotelReservations`.`Rooms` (`RoomId`, `LocationId`, `RoomNumber`, `Floor`, `OccupancyLimit`, `RoomTypeId`) VALUES (4, 1, 1, '4', 4, 2);
INSERT INTO `HotelReservations`.`Rooms` (`RoomId`, `LocationId`, `RoomNumber`, `Floor`, `OccupancyLimit`, `RoomTypeId`) VALUES (5, 1, 2, '4', 4, 3);
INSERT INTO `HotelReservations`.`Rooms` (`RoomId`, `LocationId`, `RoomNumber`, `Floor`, `OccupancyLimit`, `RoomTypeId`) VALUES (6, 1, 3, '4', 4, 3);
INSERT INTO `HotelReservations`.`Rooms` (`RoomId`, `LocationId`, `RoomNumber`, `Floor`, `OccupancyLimit`, `RoomTypeId`) VALUES (7, 1, 1, '5', 6, 4);
INSERT INTO `HotelReservations`.`Rooms` (`RoomId`, `LocationId`, `RoomNumber`, `Floor`, `OccupancyLimit`, `RoomTypeId`) VALUES (8, 2, 1, '5', 6, 4);

COMMIT;


-- -----------------------------------------------------
-- Data for table `HotelReservations`.`Amenities`
-- -----------------------------------------------------
START TRANSACTION;
USE `HotelReservations`;
INSERT INTO `HotelReservations`.`Amenities` (`AmenityId`, `Name`) VALUES (1, 'Casino');
INSERT INTO `HotelReservations`.`Amenities` (`AmenityId`, `Name`) VALUES (2, 'Refrigerator');
INSERT INTO `HotelReservations`.`Amenities` (`AmenityId`, `Name`) VALUES (3, 'Mini-Bar');
INSERT INTO `HotelReservations`.`Amenities` (`AmenityId`, `Name`) VALUES (4, 'Air conditioning');
INSERT INTO `HotelReservations`.`Amenities` (`AmenityId`, `Name`) VALUES (5, 'Jacuzzi');
INSERT INTO `HotelReservations`.`Amenities` (`AmenityId`, `Name`) VALUES (6, 'Master Suite');
INSERT INTO `HotelReservations`.`Amenities` (`AmenityId`, `Name`) VALUES (7, 'HD TV');

COMMIT;


-- -----------------------------------------------------
-- Data for table `HotelReservations`.`RoomsAmenities`
-- -----------------------------------------------------
START TRANSACTION;
USE `HotelReservations`;
INSERT INTO `HotelReservations`.`RoomsAmenities` (`RoomId`, `AmenityId`, `Quantity`) VALUES (1, 1, 1);
INSERT INTO `HotelReservations`.`RoomsAmenities` (`RoomId`, `AmenityId`, `Quantity`) VALUES (2, 1, 1);
INSERT INTO `HotelReservations`.`RoomsAmenities` (`RoomId`, `AmenityId`, `Quantity`) VALUES (3, 1, 1);
INSERT INTO `HotelReservations`.`RoomsAmenities` (`RoomId`, `AmenityId`, `Quantity`) VALUES (4, 1, 1);
INSERT INTO `HotelReservations`.`RoomsAmenities` (`RoomId`, `AmenityId`, `Quantity`) VALUES (2, 2, 1);
INSERT INTO `HotelReservations`.`RoomsAmenities` (`RoomId`, `AmenityId`, `Quantity`) VALUES (3, 2, 1);
INSERT INTO `HotelReservations`.`RoomsAmenities` (`RoomId`, `AmenityId`, `Quantity`) VALUES (4, 2, 1);
INSERT INTO `HotelReservations`.`RoomsAmenities` (`RoomId`, `AmenityId`, `Quantity`) VALUES (3, 3, 1);
INSERT INTO `HotelReservations`.`RoomsAmenities` (`RoomId`, `AmenityId`, `Quantity`) VALUES (4, 3, 1);
INSERT INTO `HotelReservations`.`RoomsAmenities` (`RoomId`, `AmenityId`, `Quantity`) VALUES (1, 4, 1);
INSERT INTO `HotelReservations`.`RoomsAmenities` (`RoomId`, `AmenityId`, `Quantity`) VALUES (2, 4, 1);
INSERT INTO `HotelReservations`.`RoomsAmenities` (`RoomId`, `AmenityId`, `Quantity`) VALUES (3, 4, 1);
INSERT INTO `HotelReservations`.`RoomsAmenities` (`RoomId`, `AmenityId`, `Quantity`) VALUES (4, 4, 1);
INSERT INTO `HotelReservations`.`RoomsAmenities` (`RoomId`, `AmenityId`, `Quantity`) VALUES (4, 5, 1);
INSERT INTO `HotelReservations`.`RoomsAmenities` (`RoomId`, `AmenityId`, `Quantity`) VALUES (3, 6, 1);
INSERT INTO `HotelReservations`.`RoomsAmenities` (`RoomId`, `AmenityId`, `Quantity`) VALUES (4, 6, 1);
INSERT INTO `HotelReservations`.`RoomsAmenities` (`RoomId`, `AmenityId`, `Quantity`) VALUES (5, 1, 1);
INSERT INTO `HotelReservations`.`RoomsAmenities` (`RoomId`, `AmenityId`, `Quantity`) VALUES (6, 1, 1);
INSERT INTO `HotelReservations`.`RoomsAmenities` (`RoomId`, `AmenityId`, `Quantity`) VALUES (7, 1, 1);
INSERT INTO `HotelReservations`.`RoomsAmenities` (`RoomId`, `AmenityId`, `Quantity`) VALUES (8, 1, 1);
INSERT INTO `HotelReservations`.`RoomsAmenities` (`RoomId`, `AmenityId`, `Quantity`) VALUES (1, 7, 1);
INSERT INTO `HotelReservations`.`RoomsAmenities` (`RoomId`, `AmenityId`, `Quantity`) VALUES (2, 7, 1);
INSERT INTO `HotelReservations`.`RoomsAmenities` (`RoomId`, `AmenityId`, `Quantity`) VALUES (3, 7, 1);
INSERT INTO `HotelReservations`.`RoomsAmenities` (`RoomId`, `AmenityId`, `Quantity`) VALUES (4, 7, 1);
INSERT INTO `HotelReservations`.`RoomsAmenities` (`RoomId`, `AmenityId`, `Quantity`) VALUES (5, 7, 1);
INSERT INTO `HotelReservations`.`RoomsAmenities` (`RoomId`, `AmenityId`, `Quantity`) VALUES (6, 7, 2);
INSERT INTO `HotelReservations`.`RoomsAmenities` (`RoomId`, `AmenityId`, `Quantity`) VALUES (7, 7, 2);
INSERT INTO `HotelReservations`.`RoomsAmenities` (`RoomId`, `AmenityId`, `Quantity`) VALUES (8, 7, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `HotelReservations`.`Customers`
-- -----------------------------------------------------
START TRANSACTION;
USE `HotelReservations`;
INSERT INTO `HotelReservations`.`Customers` (`CustomerId`, `FirstName`, `LastName`, `Phone`, `Email`) VALUES (1, 'Kyle', 'Rudy', '', 'krudy@sg.com');
INSERT INTO `HotelReservations`.`Customers` (`CustomerId`, `FirstName`, `LastName`, `Phone`, `Email`) VALUES (2, 'Corbin', 'March', '', 'cmarch@sg.com');
INSERT INTO `HotelReservations`.`Customers` (`CustomerId`, `FirstName`, `LastName`, `Phone`, `Email`) VALUES (3, 'Eric', 'Wise', '', 'ewise@sg.com');
INSERT INTO `HotelReservations`.`Customers` (`CustomerId`, `FirstName`, `LastName`, `Phone`, `Email`) VALUES (4, 'Jeff', 'Stuart', '', 'js@sg.com');

COMMIT;


-- -----------------------------------------------------
-- Data for table `HotelReservations`.`ReservationStatuses`
-- -----------------------------------------------------
START TRANSACTION;
USE `HotelReservations`;
INSERT INTO `HotelReservations`.`ReservationStatuses` (`StatusId`, `StatusName`) VALUES (1, 'Booked');
INSERT INTO `HotelReservations`.`ReservationStatuses` (`StatusId`, `StatusName`) VALUES (2, 'Active');
INSERT INTO `HotelReservations`.`ReservationStatuses` (`StatusId`, `StatusName`) VALUES (3, 'Closed');
INSERT INTO `HotelReservations`.`ReservationStatuses` (`StatusId`, `StatusName`) VALUES (4, 'Cancelled');

COMMIT;


-- -----------------------------------------------------
-- Data for table `HotelReservations`.`Reservations`
-- -----------------------------------------------------
START TRANSACTION;
USE `HotelReservations`;
INSERT INTO `HotelReservations`.`Reservations` (`ReservationId`, `CustomerId`, `StatusId`) VALUES (1, 1, 1);
INSERT INTO `HotelReservations`.`Reservations` (`ReservationId`, `CustomerId`, `StatusId`) VALUES (2, 2, 1);
INSERT INTO `HotelReservations`.`Reservations` (`ReservationId`, `CustomerId`, `StatusId`) VALUES (3, 3, 1);
INSERT INTO `HotelReservations`.`Reservations` (`ReservationId`, `CustomerId`, `StatusId`) VALUES (4, 4, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `HotelReservations`.`InvoiceStatuses`
-- -----------------------------------------------------
START TRANSACTION;
USE `HotelReservations`;
INSERT INTO `HotelReservations`.`InvoiceStatuses` (`StatusId`, `StatusName`) VALUES (1, 'Open');
INSERT INTO `HotelReservations`.`InvoiceStatuses` (`StatusId`, `StatusName`) VALUES (2, 'Paid');
INSERT INTO `HotelReservations`.`InvoiceStatuses` (`StatusId`, `StatusName`) VALUES (3, 'Cancelled');
INSERT INTO `HotelReservations`.`InvoiceStatuses` (`StatusId`, `StatusName`) VALUES (4, 'Removed');

COMMIT;


-- -----------------------------------------------------
-- Data for table `HotelReservations`.`Invoices`
-- -----------------------------------------------------
START TRANSACTION;
USE `HotelReservations`;
INSERT INTO `HotelReservations`.`Invoices` (`InvoiceId`, `CustomerId`, `Total`, `TotalTax`, `StatusId`) VALUES (1, 1, 514, 23, 1);
INSERT INTO `HotelReservations`.`Invoices` (`InvoiceId`, `CustomerId`, `Total`, `TotalTax`, `StatusId`) VALUES (2, 1, 1079, 54, 1);
INSERT INTO `HotelReservations`.`Invoices` (`InvoiceId`, `CustomerId`, `Total`, `TotalTax`, `StatusId`) VALUES (3, 2, 428, 45, 1);
INSERT INTO `HotelReservations`.`Invoices` (`InvoiceId`, `CustomerId`, `Total`, `TotalTax`, `StatusId`) VALUES (4, 3, 1500, 100, 1);
INSERT INTO `HotelReservations`.`Invoices` (`InvoiceId`, `CustomerId`, `Total`, `TotalTax`, `StatusId`) VALUES (5, 4, 1873, 134, 1);
INSERT INTO `HotelReservations`.`Invoices` (`InvoiceId`, `CustomerId`, `Total`, `TotalTax`, `StatusId`) VALUES (6, 4, 79, 13, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `HotelReservations`.`ReservationsRooms`
-- -----------------------------------------------------
START TRANSACTION;
USE `HotelReservations`;
INSERT INTO `HotelReservations`.`ReservationsRooms` (`ReservationId`, `RoomId`, `StartDate`, `EndDate`, `InvoiceId`) VALUES (1, 7, '2017/10/31', '2017/11/03', 2);
INSERT INTO `HotelReservations`.`ReservationsRooms` (`ReservationId`, `RoomId`, `StartDate`, `EndDate`, `InvoiceId`) VALUES (1, 6, '2017/10/31', '2017/11/01', 1);
INSERT INTO `HotelReservations`.`ReservationsRooms` (`ReservationId`, `RoomId`, `StartDate`, `EndDate`, `InvoiceId`) VALUES (2, 5, '2017/11/15', '2017/11/16', 3);
INSERT INTO `HotelReservations`.`ReservationsRooms` (`ReservationId`, `RoomId`, `StartDate`, `EndDate`, `InvoiceId`) VALUES (4, 4, '2017/10/12', '2017/10/16', 5);
INSERT INTO `HotelReservations`.`ReservationsRooms` (`ReservationId`, `RoomId`, `StartDate`, `EndDate`, `InvoiceId`) VALUES (4, 5, '2017/10/12', '2017/10/16', 6);
INSERT INTO `HotelReservations`.`ReservationsRooms` (`ReservationId`, `RoomId`, `StartDate`, `EndDate`, `InvoiceId`) VALUES (3, 2, '2017/10/31', '2017/11/01', 4);

COMMIT;


-- -----------------------------------------------------
-- Data for table `HotelReservations`.`Guests`
-- -----------------------------------------------------
START TRANSACTION;
USE `HotelReservations`;
INSERT INTO `HotelReservations`.`Guests` (`GuestId`, `FirstName`, `LastName`, `Age`) VALUES (1, 'Kyle', 'Rudy', 26);
INSERT INTO `HotelReservations`.`Guests` (`GuestId`, `FirstName`, `LastName`, `Age`) VALUES (2, 'Girlfriend', 'Rudy', 25);
INSERT INTO `HotelReservations`.`Guests` (`GuestId`, `FirstName`, `LastName`, `Age`) VALUES (3, 'Bob', 'Dylan', 54);
INSERT INTO `HotelReservations`.`Guests` (`GuestId`, `FirstName`, `LastName`, `Age`) VALUES (4, 'Mrs.', 'Dylan', 52);
INSERT INTO `HotelReservations`.`Guests` (`GuestId`, `FirstName`, `LastName`, `Age`) VALUES (5, 'Jeff', 'Stuart', 46);
INSERT INTO `HotelReservations`.`Guests` (`GuestId`, `FirstName`, `LastName`, `Age`) VALUES (6, 'Annabelle', 'Stuart', 43);
INSERT INTO `HotelReservations`.`Guests` (`GuestId`, `FirstName`, `LastName`, `Age`) VALUES (7, 'Tristan', 'Stuart', 10);
INSERT INTO `HotelReservations`.`Guests` (`GuestId`, `FirstName`, `LastName`, `Age`) VALUES (8, 'Travis', 'Stuart', 8);
INSERT INTO `HotelReservations`.`Guests` (`GuestId`, `FirstName`, `LastName`, `Age`) VALUES (9, 'Trevor', 'Stuart', 5);
INSERT INTO `HotelReservations`.`Guests` (`GuestId`, `FirstName`, `LastName`, `Age`) VALUES (10, 'Corbin', 'March', 47);
INSERT INTO `HotelReservations`.`Guests` (`GuestId`, `FirstName`, `LastName`, `Age`) VALUES (11, 'Eric', 'Wise', 47);

COMMIT;


-- -----------------------------------------------------
-- Data for table `HotelReservations`.`AddOns`
-- -----------------------------------------------------
START TRANSACTION;
USE `HotelReservations`;
INSERT INTO `HotelReservations`.`AddOns` (`AddOnId`, `StartDate`, `EndDate`, `UnitPrice`, `Description`) VALUES (1, '2017/01/01', '2017/12/31', 8.99, 'Movie, Wonder Woman');
INSERT INTO `HotelReservations`.`AddOns` (`AddOnId`, `StartDate`, `EndDate`, `UnitPrice`, `Description`) VALUES (2, '2017/01/01', '2017/12/31', 14.99, 'Pepperoni Pizza');
INSERT INTO `HotelReservations`.`AddOns` (`AddOnId`, `StartDate`, `EndDate`, `UnitPrice`, `Description`) VALUES (3, '2017/01/01', '2017/12/31', 15.99, 'Lobster Bisque');
INSERT INTO `HotelReservations`.`AddOns` (`AddOnId`, `StartDate`, `EndDate`, `UnitPrice`, `Description`) VALUES (4, '2017/01/01', '2017/12/31', 6.99, 'Mozarrela Sticks');
INSERT INTO `HotelReservations`.`AddOns` (`AddOnId`, `StartDate`, `EndDate`, `UnitPrice`, `Description`) VALUES (5, '2017/01/01', '2017/12/31', 4.99, 'In Room WiFi');

COMMIT;


-- -----------------------------------------------------
-- Data for table `HotelReservations`.`InvoiceDetails`
-- -----------------------------------------------------
START TRANSACTION;
USE `HotelReservations`;
INSERT INTO `HotelReservations`.`InvoiceDetails` (`InvoiceDetailId`, `InvoiceId`, `Description`, `ChargeDate`, `UnitPrice`, `Quantity`, `Discount`) VALUES (1, 5, 'Movie, Wonder Woman', '2017-10-12', 9, 1, 0);
INSERT INTO `HotelReservations`.`InvoiceDetails` (`InvoiceDetailId`, `InvoiceId`, `Description`, `ChargeDate`, `UnitPrice`, `Quantity`, `Discount`) VALUES (2, 5, 'Pepperoni Pizza', '2017-10-14', 15, 2, 0);
INSERT INTO `HotelReservations`.`InvoiceDetails` (`InvoiceDetailId`, `InvoiceId`, `Description`, `ChargeDate`, `UnitPrice`, `Quantity`, `Discount`) VALUES (3, 6, 'Pepperoni Pizza', '2017-10-12', 15, 1, 5);
INSERT INTO `HotelReservations`.`InvoiceDetails` (`InvoiceDetailId`, `InvoiceId`, `Description`, `ChargeDate`, `UnitPrice`, `Quantity`, `Discount`) VALUES (4, 5, 'Lobster Bisque', '2017-10-13', 16, 1, 0);
INSERT INTO `HotelReservations`.`InvoiceDetails` (`InvoiceDetailId`, `InvoiceId`, `Description`, `ChargeDate`, `UnitPrice`, `Quantity`, `Discount`) VALUES (5, 6, 'Mozarrela Sticks', '2017-10-13', 7, 2, 0);
INSERT INTO `HotelReservations`.`InvoiceDetails` (`InvoiceDetailId`, `InvoiceId`, `Description`, `ChargeDate`, `UnitPrice`, `Quantity`, `Discount`) VALUES (6, 6, 'In Room WiFi', '2017-10-12', 5, 1, 0);
INSERT INTO `HotelReservations`.`InvoiceDetails` (`InvoiceDetailId`, `InvoiceId`, `Description`, `ChargeDate`, `UnitPrice`, `Quantity`, `Discount`) VALUES (7, 6, 'In Room WiFi', '2017-10-13', 5, 1, 0);
INSERT INTO `HotelReservations`.`InvoiceDetails` (`InvoiceDetailId`, `InvoiceId`, `Description`, `ChargeDate`, `UnitPrice`, `Quantity`, `Discount`) VALUES (8, 6, 'In Room WiFi', '2017-10-14', 5, 1, 0);
INSERT INTO `HotelReservations`.`InvoiceDetails` (`InvoiceDetailId`, `InvoiceId`, `Description`, `ChargeDate`, `UnitPrice`, `Quantity`, `Discount`) VALUES (9, 5, 'Room Charge', '2017-10-12', 32, 1, 0);
INSERT INTO `HotelReservations`.`InvoiceDetails` (`InvoiceDetailId`, `InvoiceId`, `Description`, `ChargeDate`, `UnitPrice`, `Quantity`, `Discount`) VALUES (10, 5, 'Room Charge', '2017-10-13', 32, 1, 0);
INSERT INTO `HotelReservations`.`InvoiceDetails` (`InvoiceDetailId`, `InvoiceId`, `Description`, `ChargeDate`, `UnitPrice`, `Quantity`, `Discount`) VALUES (11, 5, 'Room Charge', '2017-10-14', 32, 1, 0);
INSERT INTO `HotelReservations`.`InvoiceDetails` (`InvoiceDetailId`, `InvoiceId`, `Description`, `ChargeDate`, `UnitPrice`, `Quantity`, `Discount`) VALUES (12, 6, 'Room Charge', '2017-10-12', 32, 1, 0);
INSERT INTO `HotelReservations`.`InvoiceDetails` (`InvoiceDetailId`, `InvoiceId`, `Description`, `ChargeDate`, `UnitPrice`, `Quantity`, `Discount`) VALUES (13, 6, 'Room Charge', '2017-10-13', 32, 1, 0);
INSERT INTO `HotelReservations`.`InvoiceDetails` (`InvoiceDetailId`, `InvoiceId`, `Description`, `ChargeDate`, `UnitPrice`, `Quantity`, `Discount`) VALUES (14, 6, 'Room Charge', '2017-10-14', 32, 1, 0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `HotelReservations`.`Promotions`
-- -----------------------------------------------------
START TRANSACTION;
USE `HotelReservations`;
INSERT INTO `HotelReservations`.`Promotions` (`PromotionId`, `PromoCode`, `StartDate`, `EndDate`, `DiscountPercent`, `DiscountFlat`) VALUES (1, 'MINECON', '2017/10/12', '2017/10/16', 5, null);
INSERT INTO `HotelReservations`.`Promotions` (`PromotionId`, `PromoCode`, `StartDate`, `EndDate`, `DiscountPercent`, `DiscountFlat`) VALUES (2, 'SuperBowl2018', '2017/02/20', '2017/02/23', null, 50);
INSERT INTO `HotelReservations`.`Promotions` (`PromotionId`, `PromoCode`, `StartDate`, `EndDate`, `DiscountPercent`, `DiscountFlat`) VALUES (3, 'Halloween', '2017/10/31', '2017/11/01', 7, null);

COMMIT;


-- -----------------------------------------------------
-- Data for table `HotelReservations`.`ReservationsPromotions`
-- -----------------------------------------------------
START TRANSACTION;
USE `HotelReservations`;
INSERT INTO `HotelReservations`.`ReservationsPromotions` (`ReservationId`, `PromotionId`) VALUES (4, 1);
INSERT INTO `HotelReservations`.`ReservationsPromotions` (`ReservationId`, `PromotionId`) VALUES (1, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `HotelReservations`.`ReservationsRoomsAddOns`
-- -----------------------------------------------------
START TRANSACTION;
USE `HotelReservations`;
INSERT INTO `HotelReservations`.`ReservationsRoomsAddOns` (`ReservationId`, `RoomId`, `AddOnId`, `ChargeDate`, `Quantity`, `Description`, `Discount`) VALUES (4, 4, 1, '2017/10/12', 1, 'Movie, Wonder Woman', NULL);
INSERT INTO `HotelReservations`.`ReservationsRoomsAddOns` (`ReservationId`, `RoomId`, `AddOnId`, `ChargeDate`, `Quantity`, `Description`, `Discount`) VALUES (4, 4, 3, '2017/10/13', 1, 'Lobster Bisque', NULL);
INSERT INTO `HotelReservations`.`ReservationsRoomsAddOns` (`ReservationId`, `RoomId`, `AddOnId`, `ChargeDate`, `Quantity`, `Description`, `Discount`) VALUES (4, 5, 2, '2017/10/12', 1, 'Pepperoni Pizza', NULL);
INSERT INTO `HotelReservations`.`ReservationsRoomsAddOns` (`ReservationId`, `RoomId`, `AddOnId`, `ChargeDate`, `Quantity`, `Description`, `Discount`) VALUES (4, 5, 4, '2017/10/13', 2, 'Mozarrella Sticks', 5);
INSERT INTO `HotelReservations`.`ReservationsRoomsAddOns` (`ReservationId`, `RoomId`, `AddOnId`, `ChargeDate`, `Quantity`, `Description`, `Discount`) VALUES (4, 4, 2, '2017/10/14', 2, 'Pepperoni Pizza', NULL);
INSERT INTO `HotelReservations`.`ReservationsRoomsAddOns` (`ReservationId`, `RoomId`, `AddOnId`, `ChargeDate`, `Quantity`, `Description`, `Discount`) VALUES (4, 5, 5, '2017/10/12', 1, 'In Room WiFi', NULL);
INSERT INTO `HotelReservations`.`ReservationsRoomsAddOns` (`ReservationId`, `RoomId`, `AddOnId`, `ChargeDate`, `Quantity`, `Description`, `Discount`) VALUES (4, 5, 5, '2017/10/13', 1, 'In Room WiFi', NULL);
INSERT INTO `HotelReservations`.`ReservationsRoomsAddOns` (`ReservationId`, `RoomId`, `AddOnId`, `ChargeDate`, `Quantity`, `Description`, `Discount`) VALUES (4, 5, 5, '2017/10/14', 1, 'In Room WiFi', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `HotelReservations`.`ReservationsRoomsGuests`
-- -----------------------------------------------------
START TRANSACTION;
USE `HotelReservations`;
INSERT INTO `HotelReservations`.`ReservationsRoomsGuests` (`ReservationId`, `RoomId`, `GuestId`) VALUES (4, 4, 5);
INSERT INTO `HotelReservations`.`ReservationsRoomsGuests` (`ReservationId`, `RoomId`, `GuestId`) VALUES (4, 4, 6);
INSERT INTO `HotelReservations`.`ReservationsRoomsGuests` (`ReservationId`, `RoomId`, `GuestId`) VALUES (4, 5, 7);
INSERT INTO `HotelReservations`.`ReservationsRoomsGuests` (`ReservationId`, `RoomId`, `GuestId`) VALUES (4, 5, 8);
INSERT INTO `HotelReservations`.`ReservationsRoomsGuests` (`ReservationId`, `RoomId`, `GuestId`) VALUES (4, 5, 9);
INSERT INTO `HotelReservations`.`ReservationsRoomsGuests` (`ReservationId`, `RoomId`, `GuestId`) VALUES (1, 7, 1);
INSERT INTO `HotelReservations`.`ReservationsRoomsGuests` (`ReservationId`, `RoomId`, `GuestId`) VALUES (1, 7, 2);
INSERT INTO `HotelReservations`.`ReservationsRoomsGuests` (`ReservationId`, `RoomId`, `GuestId`) VALUES (1, 6, 3);
INSERT INTO `HotelReservations`.`ReservationsRoomsGuests` (`ReservationId`, `RoomId`, `GuestId`) VALUES (1, 6, 4);
INSERT INTO `HotelReservations`.`ReservationsRoomsGuests` (`ReservationId`, `RoomId`, `GuestId`) VALUES (2, 5, 10);
INSERT INTO `HotelReservations`.`ReservationsRoomsGuests` (`ReservationId`, `RoomId`, `GuestId`) VALUES (3, 2, 11);

COMMIT;