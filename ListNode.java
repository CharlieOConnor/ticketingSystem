package ticketSystem;

public class ListNode
{
	Request data;      //Data in the node
	ListNode next;     //Pointer to the next node
	ListNode previous; //Pointer to the previous node

	/**
	 * Constructor for the data in the nodes
	 */
	public ListNode(Request data)
	{
		this.data = data;  //Use of "this" to initialise same named variable
	}
}