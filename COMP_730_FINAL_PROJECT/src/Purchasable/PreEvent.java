package Purchasable;

public class PreEvent extends eventExtras{

    public PreEvent(PurchasableObject pObject) {
        super(pObject);
    }
    
    @Override
    public String getName() {
        return super.getName() + " Pre-Event Activities";
    }

    @Override 
    public double getPrice() {
        return super.getPrice() + 100.00;
    }

    @Override
    public boolean purchased() {
        //Check with Jess about this section
        return true;
    }

    @Override 
    public String getEvent() {
        //Check with Jess about this section
        return super.getEvent() + "UNKNOWN";
    }
}