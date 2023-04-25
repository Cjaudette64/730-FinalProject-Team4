package Interface;
import java.util.Scanner;
import Purchaser.*;

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
        switch(option) {
            case(1):
                //send user to view list of events to choose via
                //database queries then come back to pass event
                //to Purchaser
                System.out.println("Requires database integration");
                StartScreen(username);
                break;
            case(2):
                System.out.println("Requires database integration");
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
