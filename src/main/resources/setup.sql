CREATE USER hoteluserzzg@localhost identified BY '123123';
GRANT USAGE ON *.* TO hoteluserzzg@localhost identified BY '123123';
CREATE DATABASE IF NOT EXISTS hotelinno;
GRANT ALL PRIVILEGES ON hotelinno.* TO hoteluserzzg@localhost;

use hotelinno;

/*Room(PK:RoomID, TypeID)
RoomType(PK:RoomTypeID, RoomTypeName, Price)
Hotel(PK:HotelID, HotelName, Address, FK:CityID)
RoomBooking(PK:RBID, CheckIn, CheckOut, FK:HotelID, FK:RoomID)
User(PK:UserID, FirstName, LastName, Permissions) -- 1-client, 2-admin
RoomOrder(PK:OrderID, FK:RBID, FK:UserID)
City(PK:CityID, CityName)*/

drop table IF EXISTS RoomOrder;
drop table IF EXISTS RoomBooking;
drop table IF EXISTS User;
drop table IF EXISTS Hotel;
drop table IF EXISTS Room;
drop table IF EXISTS RoomType;
drop table IF EXISTS City;

create table City (
  CityID integer UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  CityName varchar(200) NOT NULL
);

create table RoomType (
  RoomTypeID integer UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  RoomTypeName varchar(1000) NOT NULL,
  Price integer UNSIGNED NOT NULL
);

create table Room (
  RoomID integer UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  TypeID integer UNSIGNED NOT NULL,
  FOREIGN KEY (TypeID) REFERENCES RoomType(RoomTypeID)
);

create table Hotel (
  HotelID integer UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  HotelName varchar(200) NOT NULL,
  Address varchar(200) NOT NULL,
  CityID integer UNSIGNED NOT NULL,
  FOREIGN KEY (CityID) REFERENCES City(CityID)
);

create table User (
  UserID integer UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  FirstName varchar(200) NOT NULL,
  LastName varchar(200) NOT NULL,
  Permissions integer UNSIGNED NOT NULL,
  Password varchar(200) NOT NULL
);

create table RoomBooking (
  RBID integer UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  CheckIn TIMESTAMP NOT NULL,
  CheckOut TIMESTAMP NOT NULL,
  HotelID integer UNSIGNED NOT NULL,
  RoomID integer UNSIGNED NOT NULL,
  FOREIGN KEY (HotelID) REFERENCES Hotel(HotelID),
  FOREIGN KEY (RoomID) REFERENCES Room(RoomID)
);

create table RoomOrder (
  OrderID integer UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  RBID integer UNSIGNED NOT NULL,
  UserID integer UNSIGNED NOT NULL,
  FOREIGN KEY (RBID) REFERENCES RoomBooking(RBID),
  FOREIGN KEY (UserID) REFERENCES User(UserID)
);