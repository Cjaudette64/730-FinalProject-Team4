package Purchasable;

public class PostEvent extends eventExtras{

    public PostEvent(PurchasableObject pObject) {
        super(pObject);
    }
    
    @Override
    public String getName() {
        return super.getName() + " Post Event VIP Pass";
    }

    @Override 
    public double getPrice() {
        return super.getPrice() + 150.00;
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