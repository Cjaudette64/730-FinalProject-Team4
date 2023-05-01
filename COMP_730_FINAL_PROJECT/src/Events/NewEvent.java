package Events;

public class NewEvent {
    private String EventName;
    private int EventCapacity;


    //SETTERS
    public void SetEventName(String EventName)
    {
        if (EventName != null && EventName.length() > 0)
        {
            this.EventName = EventName;
        }
    } 

    public void SetEventCapacity(int EventCapacity)
    {
        if (EventCapacity > 0)
        {
            this.EventCapacity = EventCapacity;
        }
    }


    //GETTERS
    public String GetEventName()
    {
        return this.EventName;
    }

    public int GetEventCapacity()
    {
        return this.EventCapacity;
    }
}
