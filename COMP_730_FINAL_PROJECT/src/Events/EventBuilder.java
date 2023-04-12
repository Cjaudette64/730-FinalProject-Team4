package Events;

public class EventBuilder {

	//private final int id; //maybe should be linked to db PK
	private String name;
    private String datetime; //probably needs to be standardized for DB
	private String address;
    private String venue;
    private String category;
    private String organizer;
    private int ticket_limit; //need to implement tracker
    //also add purchasables

	private EventBuilder(Builder builder)
	{
		//this.id = builder.id;
		this.name = builder.name;
        this.datetime = builder.datetime;
        this.address = builder.address;
        this.venue = builder.venue;
        this.category = builder.category;
        this.organizer = builder.organizer;
        this.ticket_limit = builder.ticket_limit;
		
	}

	// Static class Builder
	public static class Builder {

		/// instance fields
		//private int id;
		private String name;
        private String datetime;
	    private String address;
        private String venue;
        private String category;
        private String organizer;
        private int ticket_limit;

		public Builder() {}

		//public Builder setId(int id)
		//{
		//	this.id = id;
		//	return this;
		//}
		public Builder setName(String name)
		{
			this.name = name;
			return this;
		}

        public Builder setDateTime(String datetime)
        {
            this.datetime = datetime;
            return this;
        }

		public Builder setAddress(String address)
		{
			this.address = address;
			return this;
		}

        public Builder setVenue(String venue)
        {
            this.venue = venue;
            return this;
        }

        public Builder setCategory(String category)
        {
            this.category = category;
            return this;
        }

        public Builder setOrganizer(String organizer){
            this.organizer= organizer;
            return this;
        }

        public Builder setTicketLimit(int ticket_limit)
        {
            this.ticket_limit = ticket_limit;
            return this;
        }

		public EventBuilder build()
		{
			return new EventBuilder(this);
		}
	}

	@Override
	public String toString()
	{
		//"id = " + this.id 
        return "Name = " + this.name + " Datetime = " + this.datetime +  
		" Address = " + this.address + " Venue = " + this.venue +
		" Category = " + this.category + " Organizer = " + this.organizer + 
		" Ticket Limit = " + Integer.toString(this.ticket_limit);
	}
}