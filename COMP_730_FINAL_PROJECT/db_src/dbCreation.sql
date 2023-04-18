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

CREATE TABLE IF NOT EXISISTS Users (
    UserID int NOT NULL AUTO_INCREMENT,
    Username varchar(20),
    UserPass varchar(50),
    PRIMARY KEY (UserID)
);

/*When users table is created, this needs a foreign key to the users table*/
CREATE TABLE IF NOT EXISTS Tickets (
	TicketID int NOT NULL AUTO_INCREMENT,
	EventID int,
    UserID int,
    TicketName varchar(50),
    /*need to discuss how pricing works*/
    TicketPrice DECIMAL(7,2), 
    AddOns SET("Food", "Park"), 
    AddOnsCost DECIMAL(7,2),
    PRIMARY KEY (TicketID),
    FOREIGN KEY (EventID) REFERENCES TicketEvents(EventID),
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
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


/*
INSERT INTO TicketEvents (EventName, EventCapacity) VALUES("TestEvent2", 1500);
SELECT * FROM TicketEvents;
INSERT INTO Tickets (EventID, TicketName, TicketPrice, AddOns, AddOnsCost) VALUES(1, "TestEvent1 Seat - 3", 100.11, 'Food,Park', 75.50);
SELECT * FROM Tickets;

*/
