package Purchasable;

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