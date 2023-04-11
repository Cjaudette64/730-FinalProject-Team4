package Purchasable;

import Purchasable.AddOns.eventExtras;

public class FoodPurchase extends eventExtras{

    public FoodPurchase(PurchasableObject pObject) {
        super(pObject);
    }
    
    @Override
    public String getName() {
        return super.getName() + " Food event voucher";
    }

    @Override 
    public double getPrice() {
        return super.getPrice() + 25.00;
    }

    @Override 
    public String getEvent() {
        //Check with Jess about this section
        return super.getEvent() + "UNKNOWN";
    }
}
