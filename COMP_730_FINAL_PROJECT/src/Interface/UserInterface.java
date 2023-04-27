package Interface;
import java.util.Scanner;
import Database.*;
import Purchasable.*;


public class UserInterface implements Interface {
    @Override
    public void StartScreen(String username) throws Exception{
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Welcome User");
        System.out.println("Choose an option below to get started: ");
        System.out.println("1: Purchase tickets");
        System.out.println("2: View purchased tickets");
        System.out.println("3. Refund tickets");
        System.out.println("4: Logout");
        int option = sc.nextInt();
        OptionHandler(option, username); 
        
    }

    public void OptionHandler(int option, String username) throws Exception
    {
        DatabaseAccess dbConnection;
        Scanner sc = new Scanner(System.in);
        switch(option) {
            case(1):
                dbConnection = new DatabaseAccessBuilder()
                    .setConnection("user=root&password=WildcatGraduate") // rename root and password to your username and password for the database login, NOT USER TABLE (SET AS CAMERONS INFO)
                    .build();

                System.out.println("\nEventID: \t Event Name: \t Event Capacity:");
                dbConnection.UserInterfaceEventViewer();

                String connection = "user=root&password=WildcatGraduate"; // rename root and password to your username and password for the database login, NOT USER TABLE (SET AS CAMERONS INFO)
                String prepStatement = "INSERT INTO Tickets (EventID, Username, TicketName, TicketPrice, AddOns, AddOnsCost) VALUES (?, ?, ?, ?, ?, ?)";
            
                Selections selections = new Selections(connection, prepStatement);
                selections.ticketSelection();

                System.out.println("\n\n");
                StartScreen(username);
                break;
            case(2):
                dbConnection = new DatabaseAccessBuilder()
                .setConnection("user=root&password=WildcatGraduate")//rename root and password to your username and password for the database login, NOT USER TABLE(SET AS CAMERONS INFO)
                .setPreparedStatement("SELECT TicketEvents.EventName, Tickets.Username, Tickets.TicketName, Tickets.TicketPrice, Tickets.AddOns, Tickets.AddOnsCost FROM Tickets INNER JOIN TicketEvents ON Tickets.EventID = TicketEvents.EventID WHERE Tickets.Username = '" + username + "'")
                .build();

                System.out.println("\nEvent Name: | Username: | Ticket Name: | Ticket Price: | Add Ons: | Add Ons Cost: ");
                dbConnection.UserInterfaceTicketViewer();

                System.out.println("\n\n\n");
                StartScreen(username);
                break;
            case(3):
                System.out.println("Enter a ticket ID to refund...");
                int ticketIDSel = sc.nextInt();
                dbConnection = new DatabaseAccessBuilder()
                .setConnection("user=root&password=WildcatGraduate")//rename root and password to your username and password for the database login, NOT USER TABLE(SET AS CAMERONS INFO)
                .setPreparedStatement("DELETE FROM Tickets WHERE TicketID ='" + ticketIDSel + "'")
                .build();

                System.out.println("\n\n\n");
                StartScreen(username);
                break;
            case(4):
                FrontInterface logout = new FrontInterface();
                System.out.println("You have successfully logged out");
                logout.StartScreen(username);
                break;
        }
    }
    
}
