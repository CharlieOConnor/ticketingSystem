package ticketSystem;

import java.util.Scanner;

public class PriorityQueue<T>

{    
	private ListNode head; //Holds the first node of the queue
	private ListNode tail; //Holds the last node of the queue
	public int length;    //Holds the length of the queue

	/**
	 * Constructor for the PriorityQueue class
	 */
	public PriorityQueue() 
	{
		this.head = null; //Queue is initially empty so head and tail are set to null and length is set to 0
		this.tail = null; 
		this.length = 0;  
	}    

	/**
	 * A method to signify if the queue is empty or not
	 */
	public boolean isEmpty() 
	{
		return length == 0;
	}

	/**
	 * Return the length of the PriorityQueue
	 */
	public int length() 
	{
		return length;
	}

	/**
	 * Add nodes/tickets to the list
	 */
	public void add(Request data) 
	{
		boolean sort = false; //Once this is set to true, the queue is considered sorted

		ListNode currentNode = new ListNode(data); //Create an instance of the ListNode class to hold data on the current ticket

		if(isEmpty()) //Call the "isEmpty" method to see if the queue is empty
		{
			head = currentNode; //If so, assign currentNode as head and tail
			//currentNode.next = tail;
			tail = currentNode;
		}

		else 
		{
			ListNode temp = head; //Used to iterate through queue. Reset after every addition

			if(currentNode.data.priority <= head.data.priority && sort != true) //Add currentNode at the start of the queue
			{
				currentNode.next = head;
				head.previous = currentNode;
				currentNode.previous = null;
				head = currentNode;
				sort = true; //End add method
			}
			//Add currentNode to the end of the queue if there's only one node in the queue
			if(currentNode.data.priority > head.data.priority && length == 1 && sort != true) 
			{
				currentNode.previous = tail;
				tail.next = currentNode;
				currentNode.next = null;
				tail = currentNode;
				sort = true; //End add method
			}

			if (length > 1 && sort != true) 
			{       	  
				while(currentNode.data.priority > temp.data.priority && temp.next != null) 
				{
					temp = temp.next;
				}
				if (currentNode.data.priority <= temp.data.priority) //
				{
					ListNode storeNext = temp;
					temp.previous.next = currentNode;
					currentNode.previous = temp.previous;
					temp.previous = currentNode;
					currentNode.next = storeNext;
					sort = true; //End add method
				}
				if (currentNode.data.priority > temp.data.priority && sort != true)
				{
					tail.next = currentNode;
					currentNode.previous = tail;
					currentNode.next = null;
					tail = currentNode;
					sort = true; //End add method  	  
				}
			}
		}
		length++; //Increase size of queue
	}

	/**
	 * Remove first node/ticket from the queue 
	 */
	public ListNode removeFirst() 
	{      
		ListNode temp = head;  
		
		if (head == tail) 
		{
			head = null; //If there's only one node left in the queue
			tail = null;			
			return temp;
		}
		else
		{                              
			head.next.previous = null; //Break both links between the head node and next node
			head = head.next;          
			temp.next = null;          
			return temp;               
		}
	}

	/**
	 * Search for specific node/ticket
	 */
	public void searchQueue(String searchID) 
	{

		Scanner scan = new Scanner(System.in); //Closed in Test class. Otherwise only one search can be made
		char ch;

		ListNode temp = head; //Create temporary variable to iterate through queue

		for(int i = 0; i < length; i++)  
		{
			if(searchID.equals(temp.data.uniqueID)) //Iterate through queue comparing every node/ticket ID with searchID
			{
				System.out.print("\nuserID is found\n\n" + temp.data); //If a match is found, print it
				System.out.println("\nDo you want to change it's priority? (Type y or n)");  //If yes, go through necessary steps to change priority
				ch = scan.next().charAt(0);
				if(ch == 'Y' || ch == 'y') 
				{
					length--;
					System.out.println("Please enter new priority"); //Ask the user to enter a new priority
					int newPriority = scan.nextInt();
					temp.data.priority = newPriority;
					if(temp.previous == null) //If the node priority being changed is the first one
					{
					head = temp.next;
					temp.next.previous = null;
					temp.next = temp;
					add(temp.data);
					}
					if(temp.next == null) //If the node priority being changed is the last one
					{
					tail = temp.previous;
					temp.previous.next = null;
					temp.previous = temp;
					add(temp.data);
					}
					if(temp.next != null & temp.previous != null) //If the node priority being changed is somewhere in the middle
					{
					temp.previous.next = temp.next;
					temp.next.previous = temp.previous;
					add(temp.data);
					}
					System.out.println("Priority changed and queue updated\n\n" + temp.data); //Print out the updated queue
				}
				temp = head;
				break;
			}
			temp = temp.next; 
		}

		if(temp != head)
		{
			System.out.println("UserID does not exist"); //Give user an output if their searchID wasn't in the queue
		}

	}   

	/**
	 * Print the contents of the PriorityQueue 
	 */
	public void printQueue() 
	{
		if (head == null)     //If the queue is empty, return nothing
		{
			return;
		}

		ListNode temp = head; //Create temporary value to iterate through queue

		while(temp != null)   //Iterate through queue and print each node until the end of the queue is reached
		{
			System.out.println(temp.data);
			temp = temp.next;
		}
       length--; //Reduce length of queue for printing current length;
	}
}