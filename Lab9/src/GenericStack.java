   /*------------------------------------------------------------------------------------
    |  Name: Natalie Martell
	|  Purpose:  Program is designed to create a stack and linked list to evaluate a postfix
	| expression
    *------------------------------------------------------------------------------------*/
import java.util.*;
public class GenericStack  {

	protected LinkedList top ;
    protected int size ;
 
    /*  Constructor  */
    public GenericStack()
    {
        top = null;
        size = 0;
    }    
    /*  Function to check if stack is empty */
    public boolean isEmpty()
    {
        return top == null;
    }    
    /*  Function to get the size of the stack */
    public int getSize()
    {
        return size;
    }    
    /*  Function to push an element to the stack */
    public void push(int data)
    {
    	LinkedList nptr = new LinkedList (data, null);
        if (top == null)
            top = nptr;
        else
        {
            nptr.setLink(top);
            top = nptr;
        }
        size++ ;
    }    
    /*  Function to pop an element from the stack */
    public Object pop()
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception") ;
        LinkedList ptr = top;
        top = ptr.getLink();
        size-- ;
        return ptr.getData();
    }    
    
    /*  Function to pop all elements from the stack */
    public void popAll() {
    	  while(!isEmpty()) {
    	      pop();
    	  }
    }
    
    /*  Function to check the top element of the stack */
    public Object peek()
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception") ;
        return top.getData();
    }    
    /*  Function to display the status of the stack */
    public void display()
    {
        System.out.print("\nStack = ");
        if (size == 0) 
        {
            System.out.print("Empty\n");
            return ;
        }
        LinkedList ptr = top;
        while (ptr != null)
        {
            System.out.print(ptr.getData()+" ");
            ptr = ptr.getLink();
        }
        System.out.println();        
    }

}