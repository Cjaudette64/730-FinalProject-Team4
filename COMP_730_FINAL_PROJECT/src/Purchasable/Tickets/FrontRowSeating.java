package Purchasable.Tickets;

import Purchasable.PurchasableObject;

public class FrontRowSeating implements PurchasableObject {
    private int eventid;
    
    public FrontRowSeating(int EventID) { 
        eventid = EventID;
    }

    @Override
    public String getName() {
        return "Front Row Seating";
    }

    @Override 
    public double getPrice() {
        return 200.00;
    }
    
    @Override 
    public int getEvent() {
        //Check with Jess about this section
        return eventid;
    }
}
