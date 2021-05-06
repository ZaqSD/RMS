
DROP DATABASE IF EXISTS RMS_APP;
CREATE DATABASE RMS_APP;

USE RMS_APP;

ALTER DATABASE RMS CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE tStation (
    staKey INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    staName VARCHAR(100),
    staX DOUBLE,
    staY DOUBLE,
    staWeight INT   /*1-Normal 2-Elevated 3-Main*/
);
CREATE INDEX iStaName ON tStation(staName);

CREATE TABLE tTrain (
    ttyKey INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    ttyName VARCHAR(50),
    ttyHasRestaurant BINARY,
    ttySeatNr INT,
    ttyDoorNr INT,
    ttyWagonNr INT
);
CREATE INDEX iTtyName ON tTrain(ttyName);

CREATE TABLE tLine (
    linType VARCHAR(3),     /*ex IC, S, RER*/
    linNr INT,              /*ex 1,2,40*/
    linKey INT NOT NULL PRIMARY KEY,
    linDestination VARCHAR(100)
    /*linDelay INT     /* 0 = 0 | 1 = undefined | 2 = suppression | x = delay */
);

CREATE INDEX iLinDestination ON tLine(linDestination);

CREATE TABLE tStationTimetable (
    timKey INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    linId INT,
    staId INT,
    timId INT,
    timTimeOnArrival TIME,
    timTimeOnDeparture TIME,
    timPlatform VARCHAR(10),
    FOREIGN KEY (linId) REFERENCES tLine (linKey) ON DELETE CASCADE ON UPDATE RESTRICT,
    FOREIGN KEY (staId) REFERENCES tStation (staKey) ON DELETE CASCADE ON UPDATE RESTRICT
);

CREATE TABLE tTicket (
    ticKey INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    linId INT,
    ticBegin DATETIME,
    ticDuration INT,
    perGen BINARY,
    perPreName VARCHAR(50),
    perName VARCHAR(50),
    perBday DATE,
    FOREIGN KEY (linId) REFERENCES tLine (linKey) ON DELETE CASCADE ON UPDATE RESTRICT
);

CREATE TABLE tNextStation (
    nexKey INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    timID INT,          /*NextStation*/
    nexAvgSpeed INT,
    nexDistance DOUBLE,
    FOREIGN KEY (timId) REFERENCES tStationTimetable (timKey) ON DELETE CASCADE ON UPDATE RESTRICT
);

INSERT INTO tStation (staName) VALUES ('Genève');
INSERT INTO tStation (staName) VALUES ('Lausanne');
INSERT INTO tStation (staName) VALUES ('Fribourg/Freiburg');
INSERT INTO tStation (staName) VALUES ('Bern');
INSERT INTO tStation (staName) VALUES ('Zürich HB');
INSERT INTO tStation (staName) VALUES ('Zürich Hardbrücke');
INSERT INTO tStation (staName) VALUES ('Zürich Stadelhofen');


INSERT INTO tTrain (ttyName, ttyHasRestaurant, ttySeatNr, ttyDoorNr, ttyWagonNr)
VALUES ('RABe 523 001', '1', '468', '16', '4');

INSERT INTO tLine(linType, linNr, linKey, linDestination) VALUES ('IC','1','1101','Zürich HB');
INSERT INTO tLine(linType, linNr, linKey, linDestination) VALUES ('IC','1','1102','Genève Aéroport');
INSERT INTO tLine(linType, linNr, linKey, linDestination) VALUES ('IC','1','1103','Zürich HB');
INSERT INTO tLine(linType, linNr, linKey, linDestination) VALUES ('IC','1','1104','Genève Aéroport');
INSERT INTO tLine(linType, linKey, linDestination) VALUES ('EC','2101','Bern');
INSERT INTO tLine(linType, linNr, linKey, linDestination) VALUES ('S','3','3101','Zürich Stadelhofen');
INSERT INTO tLine(linType, linNr, linKey, linDestination) VALUES ('S','3','3102','Zürich Hardbrücke');

INSERT INTO tStationTimetable (linId, staId, timId, timTimeOnDeparture, timPlatform)
VALUES ('1101','1','2','16:42','6');
INSERT INTO tStationTimetable (linId, staId, timId, timTimeOnArrival, timTimeOnDeparture, timPlatform)
VALUES ('1101','2','3','17:18','17:20','1');
INSERT INTO tStationTimetable (linId, staId, timId, timTimeOnArrival, timTimeOnDeparture, timPlatform)
VALUES ('1101','3','4','18:03','18:04','3');
INSERT INTO tStationTimetable (linId, staId, timId, timTimeOnArrival, timTimeOnDeparture, timPlatform)
VALUES ('1101','4','5','18:26','18:31','7');
INSERT INTO tStationTimetable (linId, staId, timTimeOnArrival, timPlatform)
VALUES ('1101','5','19:28','33');

INSERT INTO tStationTimetable (linId, staId, timId, timTimeOnDeparture, timPlatform)
VALUES ('1102','5','7','16:32','32');
INSERT INTO tStationTimetable (linId, staId, timId, timTimeOnArrival, timTimeOnDeparture, timPlatform)
VALUES ('1102','4','8','17:28','17:34','5');
INSERT INTO tStationTimetable (linId, staId, timId, timTimeOnArrival, timTimeOnDeparture, timPlatform)
VALUES ('1102','3','9','17:55','17:56','2');
INSERT INTO tStationTimetable (linId, staId, timId, timTimeOnArrival, timTimeOnDeparture, timPlatform)
VALUES ('1102','2','10','18:40','18:42','5');
INSERT INTO tStationTimetable (linId, staId, timId, timTimeOnArrival, timPlatform)
VALUES ('1102','1','11','19:18','3');

INSERT INTO tStationTimetable (linId, staId, timId, timTimeOnArrival, timTimeOnDeparture, timPlatform)
VALUES ('2101','5','12','07:08','07:10','9');
INSERT INTO tStationTimetable (linId, staId, timId, timTimeOnArrival, timPlatform)
VALUES ('2101','4','13','08:12','7');

INSERT INTO tStationTimetable (linId, staId, timId, timTimeOnDeparture, timPlatform)
VALUES ('3101','6','14','07:26','3');
INSERT INTO tStationTimetable (linId, staId, timId, timTimeOnArrival, timTimeOnDeparture, timPlatform)
VALUES ('3101','5','15','07:28','07:30','43');
INSERT INTO tStationTimetable (linId, staId, timId, timTimeOnArrival, timPlatform)
VALUES ('3101','7','16','07:33','1');

INSERT INTO tStationTimetable (linId, staId, timId, timTimeOnDeparture, timPlatform)
VALUES ('3102','7','17','07:27','1');
INSERT INTO tStationTimetable (linId, staId, timId, timTimeOnArrival, timTimeOnDeparture, timPlatform)
VALUES ('3102','5','18','07:30','07:32','41');
INSERT INTO tStationTimetable (linId, staId, timId, timTimeOnArrival, timPlatform)
VALUES ('3102','6','19','07:34','3');
