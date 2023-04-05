package Purchasable;

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
    public boolean purchased() {
        //Check with Jess about this section
        return pObject.purchased();
    }

    @Override 
    public String getEvent() {
        //Check with Jess about this section
        return pObject.getEvent();
    }

}
