package Purchasable.Tickets;

import Purchasable.PurchasableObject;

public class MidSeating implements PurchasableObject {
    
    public MidSeating() { }

    @Override
    public String getName() {
        return "Mid-level Seating";
    }

    @Override 
    public double getPrice() {
        return 125.00;
    }

    @Override 
    public String getEvent() {
        //Check with Jess about this section
        return "FILL IN";
    }
}
