INSERT INTO City (CityName) VALUES
  ('Kazan'),
  ('Moscow'),
  ('New-York'),
  ('Atlanta'),
  ('Stockholm'),
  ('Gothenburg');

INSERT INTO RoomType (RoomTypeName, Price) VALUES
  ('Econom', 100),
  ('Comfort', 200),
  ('Business', 300);

INSERT INTO Room (TypeID) VALUES
  (1),
  (1),
  (2),
  (2),
  (3),
  (3);

INSERT INTO Hotel (HotelName, Address, CityID) VALUES
  ('KazanInn', 'Pushkina street, 101', (select CityID from city where CityName = 'Kazan')),
  ('Hayat', 'Pravo-Bulachnaya str., 202', (select CityID from city where CityName = 'Kazan')),
  ('Radison Slavyanskaya', 'Pushkina str., 303', (select CityID from city where CityName = 'Moscow')),
  ('Radison Kazanskaya', 'Kazan str., 303_2', (select CityID from city where CityName = 'Moscow')),
  ('ParkInn', 'Kremlin str., 404', (select CityID from city where CityName = 'Moscow')),
  ('Hilton', '5-th avenue, 505', (select CityID from city where CityName = 'New-York')),
  ('Hotel-Motel', 'Wall street, 606', (select CityID from city where CityName = 'New-York')),
  ('Hilton', 'Kazan street, 707', (select CityID from city where CityName = 'Atlanta')),
  ('LocalHotel', 'Russian street, 808', (select CityID from city where CityName = 'Stockholm')),
  ('Hilton', 'King street, 909', (select CityID from city where CityName = 'Gothenburg'));

INSERT INTO User (FirstName, LastName, Permissions, Password) VALUES
  ('Mike', 'Tyson', 1, 'MikePass'),
  ('Anton', 'Zalaldinov', 2, 'AntonPass'),
  ('Ilya', 'Zhingalov', 2, 'IlyaPass'),
  ('Artem', 'Grodetskiy', 1, 'ArtemPass');

INSERT INTO RoomBooking (CheckIn, CheckOut, HotelID, RoomID) VALUES
  (20161113140000, 20161115120000, 1, 1),
  (20161108140000, 20161109120000, 1, 2),
  (20161110140000, 20161111120000, 1, 3),
  (20161013140000, 20161017120000, 1, 4),
  (20160920140000, 20160921120000, 2, 1),
  (20161221140000, 20161222120000, 2, 2),
  (20161223140000, 20161225120000, 2, 3),
  (20160901140000, 20160902120000, 2, 4),
  (20160901140000, 20160903120000, 2, 5);