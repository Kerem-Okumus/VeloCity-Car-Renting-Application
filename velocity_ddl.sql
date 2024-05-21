create database velocity;
use velocity;

create table Vehicle(
vehicleId int primary key,
gearType text,
color text,
carType text,
model text,
brand text,
isAvailable boolean,
fuelType text,
passengerAmount int,
dailyPrice double
);

create table Extras(
extraId int primary key,
extraName text,
price double
);

create table User(
userId int primary key,
age int,
userName text,
password text,
name_surname text,
cardNumber text,
gender text,
phoneNumber text,
email text,
cvv text,
lastDateYear text,
lastDateMonth text,
lastDateDay text
);

create table Driver(
driverId Integer primary key,
age int,
experienceYear int,
maxSpeed double,
isExperienced boolean,
isAvailable boolean
);

create table Reservation(
reservationId int primary key,
pickupDate date,
returnDate date,
pickupLocation text,
returnLocation text,
resStatus boolean,
price double,
userId int,
vehicleId int,
driverId int,
foreign key (userId) references User(userId),
foreign key (vehicleId) references Vehicle(vehicleId),
foreign key (driverId) references Driver(driverId)
);

CREATE TABLE reservationExtras (
    reservationId int,
    extraId int,
    FOREIGN KEY (reservationId) REFERENCES Reservation(reservationId),
    FOREIGN KEY (extraId) REFERENCES Extras(extraId)
);

