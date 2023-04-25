package Purchasable.Tickets;

import Purchasable.PurchasableObject;

public class MidSeating implements PurchasableObject {
    
    private int eventid;

    public MidSeating(int EventID) {
        eventid= EventID; 

    }

    @Override
    public String getName() {
        return "Mid-level Seating";
    }

    @Override 
    public double getPrice() {
        return 125.00;
    }

    @Override 
    public int getEvent() {
        //Check with Jess about this section
        return eventid;
    }
}
