package Purchaser;
import java.util.Scanner;

public class PurchaserReceiver {
    Scanner sc = new Scanner(System.in);

    public void SelectEvent(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Event: ");
        String event = sc.nextLine();
        //should check against DB for event existance here
        PurchaseSelectionScreen(event);
    }
    
    public void PurchaseSelectionScreen(String event) {
        Purchaser purchaser = new Purchaser(event);

        System.out.println("Choose an option for " + event + " below: ");
        System.out.println("1: View available tickets");
        System.out.println("2: Purchase item");
        System.out.println("3: Choose a different event");
        int option = sc.nextInt();

        OptionHandler(option, purchaser);

    }

    public void OptionHandler(int option, Purchaser purchaser) {
        switch(option) {
            case(1):
                purchaser.displayPurchasables();
                break;
            case(2):
                System.out.println("Enter ticket name to purchase:");
                String item = sc.nextLine();
                purchaser.purchaseItem(item);
                break;
            case(3):
                SelectEvent();
                break;

        }

    }
    
}
