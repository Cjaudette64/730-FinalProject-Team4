package Interface;
import java.util.Scanner;
import Events.*;

public class EventOrganizerInterface implements Interface{
    @Override
    public void StartScreen() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome Event Org");
        System.out.println("Choose an Option Below to get started:");
        System.out.println("1: Create Event");
        System.out.println("2: View existing Events");
        System.out.println("3: Logout");
        int option = sc.nextInt();

        OptionHandler(option);
        
    }

    public void OptionHandler(int option)
    {
        switch(option) {
            case(1):
                EventReceiver client = new EventReceiver();
                EventBuilder event = client.makeEvent();
                System.out.println(event.toString());
                //input event into database;
                break;
            case(2):
                System.out.println("Requires database integration");
                break;
            case(3):
                FrontInterface logout = new FrontInterface();
                System.out.println("You have successfully logged out");
                logout.StartScreen();
                break;
        }
    }
    
}
