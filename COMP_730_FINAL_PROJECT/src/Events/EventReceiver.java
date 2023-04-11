package Events;
import java.util.Scanner;
import java.util.ArrayList;

class EventReceiver {

    private EventBuilder newEvent;

    //in a visual interface this would be done with a form,
    //not sure theres really a better way to do it via CLI
    //feel free to edit this if you can think of one though
	public void makeEvent()
	{
        Scanner sc = new Scanner(System.in);
        String[] prompts = {"name", "datetime", "address", "venue",
                            "category", "organizer", "ticket limit"};
        ArrayList<String> responses = new ArrayList<String>();
        
        System.out.println("Creating a new event. Enter responses as prompted below");
        for(int i =0; i <7; i++) 
        {
            System.out.println("Enter " + prompts[i]);
            responses.add(sc.nextLine() + "");
        }

        EventBuilder.Builder builder = new EventBuilder.Builder();

        if (!responses.get(0).isEmpty()) { builder = builder.setName(responses.get(0)); }
        if (!responses.get(1).isEmpty()) { builder = builder.setDateTime(responses.get(1)); }
        if (!responses.get(2).isEmpty()) { builder = builder.setAddress(responses.get(2)); }
        if (!responses.get(3).isEmpty()) { builder = builder.setVenue(responses.get(3)); }
        if (!responses.get(4).isEmpty()) { builder = builder.setCategory(responses.get(4)); }
        if (!responses.get(5).isEmpty()) { builder = builder.setOrganizer(responses.get(5)); }
        if (!responses.get(6).isEmpty()) { builder = builder.setTicketLimit(Integer.parseInt(responses.get(6))); }
    
        EventBuilder event = builder.build();

        System.out.println(event);
        
        
        sc.close();
        //EventBuilder newEvent = new EventBuilder.Builder().build();

    }
    
    public static void main(String[] args) {
		EventReceiver test = new EventReceiver();
        test.makeEvent();
	}
	
}