package Interface;
import java.util.Scanner;
import Purchaser.*;

public class UserInterface implements Interface {
    @Override
    public void StartScreen() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome User");
        System.out.println("Choose an option below to get started: ");
        System.out.println("1: Purchase tickets");
        System.out.println("2: View purchased tickets");
        System.out.println("3: Logout");
        int option = sc.nextInt();
        
        OptionHandler(option);
        
    }

    public void OptionHandler(int option)
    {
        switch(option) {
            case(1):
                //send user to view list of events to choose via
                //database queries then come back to pass event
                //to Purchaser
                break;
            case(2):
                System.out.println("Requires database integration");
                StartScreen();
                break;
            case(3):
                FrontInterface logout = new FrontInterface();
                System.out.println("You have successfully logged out");
                logout.StartScreen();
                break;
        }
    }
    
}
