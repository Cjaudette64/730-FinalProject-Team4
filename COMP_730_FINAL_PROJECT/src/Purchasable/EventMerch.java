package Purchasable;

import Purchasable.AddOns.eventExtras;

public class EventMerch extends eventExtras{

    public EventMerch(PurchasableObject pObject) {
        super(pObject);
    }
    
    @Override
    public String getName() {
        return super.getName() + " Event Merchandise (1 sweatshirt, 1 hat, and 1 poster)";
    }

    @Override 
    public double getPrice() {
        return super.getPrice() + 50.00;
    }
    
    @Override 
    public String getEvent() {
        //Check with Jess about this section
        return super.getEvent() + "UNKNOWN";
    }
}