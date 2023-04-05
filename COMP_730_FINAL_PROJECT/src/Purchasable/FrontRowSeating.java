package Purchasable;

public class FrontRowSeating implements PurchasableObject {
    
    public FrontRowSeating() { }

    @Override
    public String getName() {
        return "Front Row Seating";
    }

    @Override 
    public double getPrice() {
        return 200.00;
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
