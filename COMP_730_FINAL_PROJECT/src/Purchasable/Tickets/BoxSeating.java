package Purchasable.Tickets;

import Purchasable.PurchasableObject;

public class BoxSeating implements PurchasableObject {
    
    private int eventid;

    public BoxSeating(int EventID) { 
        eventid= EventID;

    }

    @Override
    public String getName() {
        return "Box Office Seating";
    }

    @Override 
    public double getPrice() {
        return 500.00;
    }

    @Override 
    public int getEvent() {
        //Check with Jess about this section
        return eventid;
    }
}
