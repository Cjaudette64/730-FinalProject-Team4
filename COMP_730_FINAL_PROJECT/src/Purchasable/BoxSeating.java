package Purchasable;

public class BoxSeating implements PurchasableObject {
    
    public BoxSeating() { }

    @Override
    public String getName() {
        return "Box Office Seating";
    }

    @Override 
    public double getPrice() {
        return 500.00;
    }

    @Override
    public boolean purchased() {
        //Check with Jess about this section
        return true;
    }

    @Override 
    public String getEvent() {
        //Check with Jess about this section
        return "FILL IN";
    }
}
