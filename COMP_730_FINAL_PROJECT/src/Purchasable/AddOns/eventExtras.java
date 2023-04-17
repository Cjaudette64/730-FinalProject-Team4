package Purchasable.AddOns;

import Purchasable.PurchasableObject;

public abstract class eventExtras implements PurchasableObject{
    
    private PurchasableObject pObject;

    public eventExtras(PurchasableObject pObject) {
        this.pObject = pObject;
    }

    @Override
    public String getName() {
        return pObject.getName();
    }

    @Override 
    public double getPrice() {
        return pObject.getPrice();
    }

    @Override 
    public String getEvent() {
        return pObject.getEvent();
    }

}
