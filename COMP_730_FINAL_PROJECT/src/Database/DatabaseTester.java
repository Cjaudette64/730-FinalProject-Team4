package Database;

import Database.DatabaseAccess;
import Database.DatabaseAccessBuilder;

public class DatabaseTester {
    public static void main(String[] args) throws Exception {
        DatabaseAccess dbTest = new DatabaseAccessBuilder()
        .setConnection("user=root&password=WildcatGraduate")//rename root and password to your username and password for the database
        .setPreparedStatement("INSERT INTO Tickets (EventID, UserID, TicketName, TicketPrice, AddOns, AddOnsCost) VALUES(?, ?, ?, ?, ?, ?)")
        .build();
        dbTest.runInsertQuery();
    }
}
