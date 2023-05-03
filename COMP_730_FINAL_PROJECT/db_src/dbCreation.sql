/*      ---NOTE: THIS IS SOME DATABASE CODE YOU MAY WANT TO RUN BEFORE STARTING THE PROGRAM---
USE final_project730;

INSERT INTO TicketEvents (EventName, EventCapacity) VALUES("TestEvent2", 333);
SELECT * FROM TicketEvents;

INSERT INTO Users (Username, UserPass) VALUES("root", "YES");
SELECT * FROM Users;

INSERT INTO Tickets (EventID, Username, TicketName, TicketPrice, AddOns, AddOnsCost) VALUES(1, "root", "Box", 200.99, 'Food,Merch', 148.50);
SELECT * FROM Tickets;

SELECT TicketEvents.EventName, Tickets.Username, Tickets.TicketName, Tickets.TicketPrice, Tickets.AddOns, Tickets.AddOnsCost
FROM Tickets
INNER JOIN TicketEvents ON Tickets.EventID = TicketEvents.EventID
WHERE Tickets.Username = "root";
*/
CREATE DATABASE IF NOT EXISTS final_project730;

USE final_project730;
DROP TABLE IF EXISTS Tickets;
DROP TABLE IF EXISTS TicketEvents;
DROP TRIGGER IF EXISTS BeforeInsertTickets;

CREATE TABLE IF NOT EXISTS TicketEvents (
	EventID int NOT NULL AUTO_INCREMENT,
    EventName varchar(100),
    EventCapacity int,
    PRIMARY KEY (EventID)
);

CREATE TABLE IF NOT EXISTS Users (
    Username varchar(30) NOT NULL,
    UserPass varchar(50),
    PRIMARY KEY (Username)
);

/*When users table is created, this needs a foreign key to the users table*/
CREATE TABLE IF NOT EXISTS Tickets (
	TicketID int NOT NULL AUTO_INCREMENT,
	EventID int,
    Username varchar(30),
    TicketName ENUM("Basic", "Mid", "FrontRow", "Box"),
    TicketPrice DECIMAL(7,2), 
    AddOns SET("Park", "Merch", "Food"), 
    AddOnsCost DECIMAL(7,2),
    PRIMARY KEY (TicketID),
    FOREIGN KEY (EventID) REFERENCES TicketEvents(EventID),
    FOREIGN KEY (Username) REFERENCES Users(Username)
);

DELIMITER //

CREATE TRIGGER IF NOT EXISTS BeforeInsertTickets
BEFORE INSERT
ON Tickets FOR EACH ROW
BEGIN 
    DECLARE numtickets INT;
    DECLARE eventcap INT;
    
    SELECT COUNT(TicketID)
    INTO numtickets
    FROM Tickets 
    WHERE Tickets.EventID = NEW.EventID;

    SELECT EventCapacity
    INTO eventcap
    FROM TicketEvents
    WHERE NEW.EventID = TicketEvents.EventID;

    IF (numtickets + 1) > eventcap THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Event capacity cannot be exceeded, no tickets left!';
    END IF;

END //

DELIMITER ;

