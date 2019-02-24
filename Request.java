package ticketSystem;

class Request
{
	String jobRequest;  
	int    priority;
	String uniqueID;
	String creator;
	String owner;

	/**
	 * Create an instance of the Request class to hold data on individual tickets
	 */
	public Request(String jobRequest, int priority, String uniqueID, String creator, String owner) 
	{
		this.jobRequest = jobRequest;
		this.priority = priority;
		this.uniqueID = uniqueID;
		this.creator = creator;
		this.owner = owner;
	}  

	/** 
	 * Print the actual data of the ticket, and not it's memory location
	 */
	public String toString() 
	{
		return "Job Name: " +jobRequest+ "\nPriority: " +priority+ "\nuniqueID: " +uniqueID 
				+ "\nCreator: " +creator+ "\nOwner: " +owner+ "\n";
	}
}