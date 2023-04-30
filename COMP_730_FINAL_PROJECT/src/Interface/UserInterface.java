package Interface;
import java.util.Scanner;
import Database.*;
import Purchasable.*;

import Purchasable.Tickets.NewTicket;

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
                //send user to view list of events to choose via
                //database queries then come back to pass event
                //to Purchaser
                System.out.print("\033[H\033[2J");
                System.out.flush();
                dbConnection = new DatabaseAccessBuilder()
                .setConnection("user=root&password=UR_DB_LOGIN")//rename root and password to your username and password for the database login, NOT USER TABLE (SET AS CAMERONS INFO)
                .build();

                NewTicket TicketPurchase = new NewTicket();
                TicketPurchase.SetTicketAssocUsername(username);

                System.out.println("\nEventID: \t Event Name: \t Event Capacity:");
                dbConnection.UserInterfaceEventViewer();


                System.out.println("\nEnter the Event ID: ");
                TicketPurchase.SetEventID(sc.nextInt());

                System.out.println("Select seat type:\n1. Basic\n2. Mid\n3. Front-Row\n4. Box");
                int TicketType = sc.nextInt();

                switch(TicketType)
                {
                    case 1:
                        TicketPurchase.SetTicketPrice(75.00);
                        TicketPurchase.SetTicketName(TicketType);
                        break;
                    case 2:
                        TicketPurchase.SetTicketPrice(125.00);
                        TicketPurchase.SetTicketName(TicketType);
                        break;
                    case 3:
                        TicketPurchase.SetTicketPrice(200.00);
                        TicketPurchase.SetTicketName(TicketType);
                        break;
                    case 4:
                        TicketPurchase.SetTicketPrice(500.00);
                        TicketPurchase.SetTicketName(TicketType);
                        break;
                    default:
                        System.out.println("Invalid selection, defaulting to Basic ticket.");
                        TicketPurchase.SetTicketPrice(75.00);
                        TicketPurchase.SetTicketName(1);
                        break;
                }

                String eventExtras = "";
                double extrasCost = 0.00;

                System.out.println("Do you want parking? (y/n)");
                boolean parking = sc.next().equalsIgnoreCase("y");

                System.out.println("Do you want merchandise? (y/n)");
                boolean merch = sc.next().equalsIgnoreCase("y");

                System.out.println("Do you want food? (y/n)");
                boolean food = sc.next().equalsIgnoreCase("y");

                if (parking)
                {
                    eventExtras = "Park,";
                    extrasCost += 50.00;
                }
                if (merch)
                {
                    eventExtras += "Merch,";
                    extrasCost += 75.00;
                }
                if (food)
                {
                    eventExtras += "Food";
                    extrasCost += 45.00;
                }
                if (eventExtras.charAt(eventExtras.length()-1) == ',')              //remove the last char if it's a ',' b/c that breaks insert
                    eventExtras = eventExtras.substring(0, eventExtras.length()-1);
                
                TicketPurchase.SetAddOns(eventExtras);
                TicketPurchase.SetAddOnsCost(extrasCost);

                
                System.out.print("\033[H\033[2J");
                System.out.flush();
                
                dbConnection = new DatabaseAccessBuilder()
                .setConnection("user=root&password=UR_DB_LOGIN")//rename root and password to your username and password for the database login, NOT USER TABLE (SET AS CAMERONS INFO)
                .setPreparedStatement("INSERT INTO Tickets (EventID, Username, TicketName, TicketPrice, AddOns, AddOnsCost) VALUES (" + TicketPurchase.GetEventID() + ", '" + TicketPurchase.GetTicketAssocUsername() + "', " + TicketPurchase.GetTicketName() + ", " + TicketPurchase.GetTicketPrice() + ", '" + TicketPurchase.GetAddOns() + "', " + TicketPurchase.GetAddOnsCost() + ");")
                .build();

                dbConnection.UserInterfaceTicketInsert();

                System.out.println("\n\n\n");
                StartScreen(username);
                break;
            case(2):
                System.out.print("\033[H\033[2J");      //SCREENCLEAR
                System.out.flush();                         //SCREENCLEAR
                dbConnection = new DatabaseAccessBuilder()
                .setConnection("user=root&password=UR_DB_LOGIN")//rename root and password to your username and password for the database login, NOT USER TABLE(SET AS CAMERONS INFO)
                .setPreparedStatement("SELECT TicketEvents.EventName, Tickets.Username, Tickets.TicketName, Tickets.TicketPrice, Tickets.AddOns, Tickets.AddOnsCost FROM Tickets INNER JOIN TicketEvents ON Tickets.EventID = TicketEvents.EventID WHERE Tickets.Username = '" + username + "'")
                .build();

                System.out.println("\nEvent Name: | Username: | Ticket Name: | Ticket Price: | Add Ons: | Add Ons Cost: ");
                dbConnection.UserInterfaceTicketViewer();

                System.out.println("\n\n\n");
                StartScreen(username);
                break;
            case(3):
                System.out.print("\033[H\033[2J"); //SCREENCLEAR
                System.out.flush();                 //SCREENCLEAR
                System.out.println("\nEnter a ticket ID to refund...");
                int ticketIDSel = sc.nextInt();
                dbConnection = new DatabaseAccessBuilder()
                .setConnection("user=root&password=UR_DB_LOGIN")//rename root and password to your username and password for the database login, NOT USER TABLE(SET AS CAMERONS INFO)
                .setPreparedStatement("DELETE FROM Tickets WHERE TicketID = " + ticketIDSel + ";")
                .build();

                dbConnection.UserInterfaceTicketRefund();

                System.out.println("\n\n\n");
                StartScreen(username);
                break;
            case(4):
                System.out.print("\033[H\033[2J");      //SCREENCLEAR
                System.out.flush();                     //SCREENCLEAR
                FrontInterface logout = new FrontInterface();
                System.out.println("You have successfully logged out");
                logout.StartScreen(username);
                break;
        }
    }
    
}
