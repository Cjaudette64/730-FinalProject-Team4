package Purchasable;

public interface PurchasableObject {
    public String getName();
    public double getPrice();
    public boolean purchased();
    //pretty sure in this case all purchasable objects would be tied to an event no?
    public String getEvent(); 

}
