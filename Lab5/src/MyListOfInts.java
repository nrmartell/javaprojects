   /*------------------------------------------------------------------------------------
    |  Name: Natalie Martell
    |  Date Modified 3/8/17	
    |  Purpose:  Program is designed to create a linked list and use recursion to
    |  perform certain tasks like printing the list, finding the max and adding values
    *------------------------------------------------------------------------------------*/



public class MyListOfInts {

   private ListOperations head, tail;
   
	public int firstInt;
	
	public MyListOfInts restOfTheInts;

	public MyListOfInts(int f){ 
		firstInt=f;
	}

	public MyListOfInts(int f, MyListOfInts r){ 
	firstInt=f;
	restOfTheInts=r;
	}

}

