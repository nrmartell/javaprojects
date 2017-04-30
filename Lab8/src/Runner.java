
   /*------------------------------------------------------------------------------------
    |  Name: Natalie Martell
	|  Purpose:  Program is designed to create a queue and perform different tasks such 
	|  as enqueue, dequeue, reversing the queue, and doubling the queue size in the event
	|  that the queue becomes full.
    *------------------------------------------------------------------------------------*/



import java.util.Stack;

public class Runner {

	public static void main(String[] args) {
		
		//declaring and initializing the queue 
		Queue q = new Queue();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		
		System.out.println("My queue is as follows:");
		//print queue function
		printQueue(q); 

		System.out.println();
		
		System.out.println("I am going to dequeue one elemenet.");
		// dequeue function
		q.dequeue();
		
		System.out.println("My queue is now as  follows:");
		//print queue
		printQueue(q); 
		System.out.println();
		
		
		System.out.println("I am going to reverse my Queue.");
		//reverse queue function
		reverseQueue(q);
		System.out.println("My queue is as follows:");
		printQueue(q);
		System.out.println();
		
		System.out.println("I am going to enqueue 60.");
		//enqueue function
		q.enqueue(60);
		System.out.println("My queue is as follows:");
		printQueue(q);
		System.out.println();
		
		System.out.println("I am going to enqueue 70.");
		q.enqueue(70);
		System.out.println();
		
		System.out.println("My queue is as follows:");
		printQueue(q);	
		System.out.println();
		
		System.out.println("I am going to reverse my Queue.");
		reverseQueue(q);
		
		System.out.println("My Queue is as Follows:");
		printQueue(q);
	}
	
	public static void printQueue(Queue q){
		int s = q.size();
		for (int i=0; i<s; i++){
			int temp =(int)q.dequeue(); q.enqueue(temp); System.out.print(temp+" ");
		}
		System.out.println();
	}
	
	public static void reverseQueue(Queue q){
		Stack<Object> reverseQ = new Stack<Object>();  

	    while(!q.isEmpty())
	    {  //  the queue elements will be added into the new stack
	       reverseQ.push(q.dequeue());
	    } 

	    //while the stack is not empty
	    while(!reverseQ.isEmpty())
	    { //our stack elements will now be put back into the queue
	     // order will now be reversed
	      q.enqueue(reverseQ.pop());
	    }
		
	}
}