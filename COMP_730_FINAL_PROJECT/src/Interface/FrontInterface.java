package Interface;
import java.util.Scanner;

public class FrontInterface implements Interface {

    public void StartScreen () {
        Scanner sc = new Scanner(System.in);
       
        System.out.println("Welcome to Ticketura. Login to get started");
        System.out.println("Username: ");
        String username = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();
        System.out.println("Flag (1=User, 2=Org, 3=Admin): ");
        int flag = sc.nextInt();
        sc.close();
        
        Login(username, password, flag);
    }

    public void Login(String user, String pass, int flag) {
        //later needs to be implemented with database:
        //flag will come from checking user and pass against
        //database and then getting flag from flag collumn

        switch(flag) {
            case(1):
                UserInterface userint = new UserInterface();
                userint.StartScreen();
                break;
            case(2):
                EventOrganizerInterface eventint = new EventOrganizerInterface();
                eventint.StartScreen();
                break;
            case(3):
                AdminInterface adminint = new AdminInterface();
                adminint.StartScreen();
                break;
        }
    }  
    
    public static void main(String[] args) {
        FrontInterface fint = new FrontInterface();
        fint.StartScreen();
    }
}

