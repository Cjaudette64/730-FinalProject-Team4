package Purchasable;

public class BasicSeating implements PurchasableObject {
    
    public BasicSeating() { }

    @Override
    public String getName() {
        return "Basic Seating";
    }

    @Override 
    public double getPrice() {
        return 75.00;
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
