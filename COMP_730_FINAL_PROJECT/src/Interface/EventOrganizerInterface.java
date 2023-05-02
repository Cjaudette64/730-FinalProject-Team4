package Interface;
import java.util.Scanner;
import Database.*;
import Events.*;

public class EventOrganizerInterface implements Interface{
    @Override
    public void StartScreen(String username) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome Event Org");
        System.out.println("Choose an Option Below to Get Started:");
        System.out.println("1: Create Event");
        System.out.println("2: View existing Events");
        System.out.println("3: Modify Existing Event");
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
                System.out.print("\033[H\033[2J");
                System.out.flush();

                NewEvent createNewEvent = new NewEvent();
                
                System.out.println("\nEnter Event name:");
                createNewEvent.SetEventName(sc.nextLine());

                System.out.println("\nEnter Event capacity:");
                createNewEvent.SetEventCapacity(sc.nextInt());

                System.out.print("\033[H\033[2J");
                System.out.flush();

                dbConnection = new DatabaseAccessBuilder()
                .setConnection("user=root&password=tY77nM-8o1gh")//rename root and password to your username and password for the database login, NOT USER TABLE (SET AS CAMERONS INFO)
                .setPreparedStatement("INSERT INTO TicketEvents (EventName, EventCapacity) VALUES('" + createNewEvent.GetEventName() + "', " + createNewEvent.GetEventCapacity() + ");")
                .build();

                dbConnection.EventInterfaceEventInsert();

                System.out.println("\n\n\n");
                StartScreen(username);
                break;
            case(2):
                System.out.print("\033[H\033[2J");
                System.out.flush();
                
                dbConnection = new DatabaseAccessBuilder()
                .setConnection("user=root&password=tY77nM-8o1gh")//rename root and password to your username and password for the database login, NOT USER TABLE (SET AS CAMERONS INFO)
                .build();

                System.out.println("\nEventID: \t Event Name: \t Event Capacity:");
                dbConnection.InterfaceEventViewer();

                System.out.println("\n\n\n");
                StartScreen(username);
                break;
            case(3):
                System.out.print("\033[H\033[2J");
                System.out.flush();

                //WE WANT THIS HERE BECAUSE IT'S EASIER TO JUST READ THE EVENTS FROM THE SAME SCREEN INSTEAD OF TRYING TO REMEMBER THE LIST OF EVENTS
                dbConnection = new DatabaseAccessBuilder()
                .setConnection("user=root&password=tY77nM-8o1gh")//rename root and password to your username and password for the database login, NOT USER TABLE (SET AS CAMERONS INFO)
                .build();

                System.out.println("\nEventID: \t Event Name: \t Event Capacity:");
                dbConnection.InterfaceEventViewer();

                int EventIDToChange = 0;
                String modifiedEventName = "";
                int modifiedEventCap = 0;

                System.out.println("\nEnter EventID to update:");
                EventIDToChange = sc.nextInt();
                
                sc.nextLine(); //consume next line that nextInt doesn't consume before getting input from user, otherwise skips user input
                System.out.println("\nEnter new event name (enter 0 to skip changing):");
                modifiedEventName = sc.nextLine();

                System.out.println("\nEnter new event capacity (enter 0 to skip changing):");
                modifiedEventCap = sc.nextInt();

                if (EventIDToChange <= 0)
                {
                    System.out.println("\nEntered invalid EventID! Returning to menu.");
                    System.out.println("\n\n\n");
                    StartScreen(username);
                    break;
                }

                if (modifiedEventName == "0" && modifiedEventCap != 0)
                {
                    //change just event cap
                    dbConnection = new DatabaseAccessBuilder()
                    .setConnection("user=root&password=tY77nM-8o1gh")//rename root and password to your username and password for the database login, NOT USER TABLE (SET AS CAMERONS INFO)
                    .setPreparedStatement("UPDATE TicketEvents SET EventCapacity = " + modifiedEventCap + " WHERE EventID = " + EventIDToChange + ";")
                    .build();

                   // dbConnection.EventInterfaceEventUpdate();
                } else if (modifiedEventName != "0" && modifiedEventCap == 0)
                {
                    //change just event name
                    dbConnection = new DatabaseAccessBuilder()
                    .setConnection("user=root&password=tY77nM-8o1gh")//rename root and password to your username and password for the database login, NOT USER TABLE (SET AS CAMERONS INFO)
                    .setPreparedStatement("UPDATE TicketEvents SET EventName = '" + modifiedEventName + "' WHERE EventID = " + EventIDToChange + ";")
                    .build();

                    //dbConnection.EventInterfaceEventUpdate();
                } else if (modifiedEventName != "0" && modifiedEventCap != 0)
                {
                    //change both
                    dbConnection = new DatabaseAccessBuilder()
                    .setConnection("user=root&password=tY77nM-8o1gh")//rename root and password to your username and password for the database login, NOT USER TABLE (SET AS CAMERONS INFO)
                    .setPreparedStatement("UPDATE TicketEvents SET EventName = '" + modifiedEventName + "', EventCapacity = " + modifiedEventCap + " WHERE EventID = " + EventIDToChange + ";")
                    .build();

                    //dbConnection.EventInterfaceEventUpdate();
                } else 
                {
                    //change nothing
                    System.out.println("No information to update! Returning to menu.");
                    System.out.println("\n\n\n");
                    StartScreen(username);
                    break;
                }
                
                System.out.print("\033[H\033[2J");
                System.out.flush();

                dbConnection.EventInterfaceEventUpdate();

                System.out.println("\n\n\n");
                StartScreen(username);
                break;
            case(4):
                FrontInterface logout = new FrontInterface();
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("You have successfully logged out");
                logout.StartScreen(username);
                break;
        }
    }
    
}
