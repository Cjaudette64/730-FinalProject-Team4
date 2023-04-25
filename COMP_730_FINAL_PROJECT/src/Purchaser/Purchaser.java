package Purchaser;
import Purchasable.Tickets.*;

public class Purchaser {
    //All of the below current has placeholder code for the 
    //sake of the PurchaserReceiver
    
    String eventName;
    //Need something to track user as well
    
    public Purchaser(String event) {
        //initialze/get entry from the database
        //based on given event name.
        eventName = event;
    }
    
    public void displayPurchasables() {
        //discuss this section. it will depend on how
        //we plan on implementing ticket purchases
        System.out.println("Basic Seating");

    }

    public void purchaseItem(String item) {
        //item = something listed in displayPurchasables
        //create the relevant Purchable object and use that
        //to insert into the database

        //not sure how this is going to work having split purchasables
        //into so many different classes

        //BasicSeating newTicket = new BasicSeating();
        //insert obj into database using previously defined constructor variables
        //System.out.println("You have purchased " + newTicket.getName() + " for " 
        //                    + "$" + String.valueOf(newTicket.getPrice()));

    }
}
