package Interface;
import java.util.Scanner;
import Events.*;

public class EventOrganizerInterface implements Interface{
    @Override
    public void StartScreen() throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome Event Org");
        System.out.println("Choose an Option Below to Get Started:");
        System.out.println("1: Create Event");
        System.out.println("2: View existing Events");
        System.out.println("3: Modify Existing Event");
        System.out.println("4: Logout");
        int option = sc.nextInt();

        OptionHandler(option);
        
    }

    public void OptionHandler(int option) throws Exception
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
                StartScreen();
                break;
            case(3):
                System.out.println("Requires database integration");
            case(4):
                FrontInterface logout = new FrontInterface();
                System.out.println("You have successfully logged out");
                logout.StartScreen();
                break;
        }
    }
    
}
