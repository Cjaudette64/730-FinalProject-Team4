package Database;

import Database.DatabaseAccess;
import Database.DatabaseAccessBuilder;

public class DatabaseTester {
    public static void main(String[] args) throws Exception {
        String username = "John Doe";
        DatabaseAccess dbTest = new DatabaseAccessBuilder()
        .setConnection("user=root&password=tY77nM-8o1gh")//rename root and password to your username and password for the database (SET AS CAMERONS INFO)
        //.setPreparedStatement("INSERT INTO Tickets (EventID, UserID, TicketName, TicketPrice, AddOns, AddOnsCost) VALUES(?, ?, ?, ?, ?, ?)")
        //.setPreparedStatement("SELECT * FROM TicketEvents")
        .setPreparedStatement("SELECT TicketEvents.EventName, Tickets.Username, Tickets.TicketName, Tickets.TicketPrice, Tickets.AddOns, Tickets.AddOnsCost FROM TicketEvents, Tickets WHERE Tickets.Username = '" + username + "'")
        .build();
        //dbTest.runInsertQuery();
        dbTest.UserInterfaceTicketViewer();
    }
}
