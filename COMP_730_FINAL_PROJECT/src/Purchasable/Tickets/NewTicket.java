package Purchasable.Tickets;

public class NewTicket {

    private int EventID;
    private String TicketAssocUsername;
    private int TicketName;
    private double TicketPrice;
    private String AddOns;
    private double AddOnsCost;

    public void SetEventID(int EventID)
    {
        this.EventID = EventID;
    }
    
    public void SetTicketAssocUsername(String TicketAssocUsername)
    {
        this.TicketAssocUsername = TicketAssocUsername;
    }

    public void SetTicketName(int TicketName)
    {
        this.TicketName = TicketName;
    }

    public void SetTicketPrice(double TicketPrice)
    {
        this.TicketPrice = TicketPrice;
    }

    public void SetAddOns(String AddOns)
    {
        this.AddOns = AddOns;
    }

    public void SetAddOnsCost(double AddOnsCost)
    {
        this.AddOnsCost = AddOnsCost;
    }

    //*****GETTERS BELOW:******

    public int GetEventID()
    {
        return this.EventID;
    }
    
    public String GetTicketAssocUsername()
    {
        return this.TicketAssocUsername;
    }

    public int GetTicketName()
    {
        return this.TicketName;
    }

    public double GetTicketPrice()
    {
        return this.TicketPrice;
    }

    public String GetAddOns()
    {
        return this.AddOns;
    }

    public double GetAddOnsCost()
    {
        return this.AddOnsCost;
    }

}
