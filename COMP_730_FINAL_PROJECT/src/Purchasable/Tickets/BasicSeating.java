package Purchasable.Tickets;

import Purchasable.PurchasableObject;

public class BasicSeating implements PurchasableObject {

    private int eventid;
    
    public BasicSeating(int EventID) { 
        eventid = EventID;
    }

    @Override
    public String getName() {
        return "Basic Seating";
    }

    @Override 
    public double getPrice() {
        return 75.00;
    }

    @Override 
    public int getEvent() {
        //Check with Jess about this section
        return eventid;
    }
}
