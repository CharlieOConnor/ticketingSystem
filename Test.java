package ticketSystem;

import java.util.Scanner;

public class Test
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Ticketing System\n");
		PriorityQueue<Request> pq = new PriorityQueue<Request>(); //Create an instance of the LinkedList class

		char ch; //Create a variable to hold the user's answer to a question
			            
		pq.add(new Request("Software Installation", 3, "1524", "Richard", "Alex")); //Add new tickets to the queue	
		pq.add(new Request("Security Issue", 1, "8624", "Richard", "Alster"));
		pq.add(new Request("Network Issue", 2, "2452", "Richard", "Samantha")); 
		pq.add(new Request("New Computer Configuration", 4, "7564", "Richard", "Samantha"));
		pq.add(new Request("New Computer Configuration", 4, "6242", "Richard", "Hailey"));
		pq.add(new Request("Security Issue", 1, "2584", "Richard", "Samantha"));

		pq.length = pq.length +1; //Reset length of tickets for printing
		pq.printQueue(); //Printed the sorted queue

		do //Allow user to search for multiple IDs until they say no
		{
			System.out.println("\nPlease enter ID to search");
			pq.searchQueue(scan.next());
			System.out.println("\nDo you want to continue? (Type y or n)");
			ch = scan.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');

		scan.close(); //Prevent resource leak

		System.out.println("RESULTS OF ANY CHANGES MADE -->");
		pq.printQueue();  //Print the sorted queue after any priority changes that may have been made

		
		pq.removeFirst();
		System.out.print("\n\n\nTICKET REMOVED --> REMAINING TICKETS: "+pq.length()+"\n\n");  //Remove tickets one by one until the queue is empty
		pq.printQueue();

		pq.removeFirst();
		System.out.print("\n\n\nTICKET REMOVED --> REMAINING TICKETS: "+pq.length()+"\n\n");
		pq.printQueue();

		pq.removeFirst();
		System.out.print("\n\n\nTICKET REMOVED --> REMAINING TICKETS: "+pq.length()+"\n\n");
		pq.printQueue();

		pq.removeFirst();
		System.out.print("\n\n\nTICKET REMOVED --> REMAINING TICKETS: "+pq.length()+"\n\n");
		pq.printQueue();
		
		pq.removeFirst();
		System.out.print("\n\n\nTICKET REMOVED --> REMAINING TICKETS: "+pq.length()+"\n\n");
		pq.printQueue();

		pq.removeFirst();
		System.out.print("\n\n\nALL TICKETS REMOVED --> REMAINING TICKETS: "+pq.length()+"\n\n");
		pq.printQueue();		
	}
}


