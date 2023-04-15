USE final_project730;
DROP TABLE Tickets;
DROP TABLE Events;

CREATE TABLE IF NOT EXISTS Events (
	EventID int NOT NULL AUTO_INCREMENT,
    EventName varchar(100),
    EventCapacity int,
    PRIMARY KEY (EventID)
);

CREATE TABLE IF NOT EXISTS Tickets (
	TicketID int NOT NULL AUTO_INCREMENT,
	EventID int,
    TicketName varchar(50),
    IsAvailable BOOL DEFAULT 1,
    TicketPrice DECIMAL(7,2),
    AddOns SET("Food", "Park"),
    AddOnsCost DECIMAL(7,2),
    PRIMARY KEY (TicketID),
    FOREIGN KEY (EventID) REFERENCES Events(EventID)
);

/*INSERT INTO Events (EventName, EventCapacity) VALUES("TestEvent2", 1500);
SELECT * FROM Events;
INSERT INTO Tickets (EventID, TicketName, TicketPrice, AddOns, AddOnsCost) VALUES(1, "TestEvent1 Seat - 1", 100.11, 'Food,Park', 75.50);
SELECT * FROM Tickets;*/