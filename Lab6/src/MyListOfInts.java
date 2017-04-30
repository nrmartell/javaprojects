   /*------------------------------------------------------------------------------------
    |  Name: Natalie Martell
    |  Purpose:  Program is designed to create a linked list and use recursion to
    |  perform certain tasks like printing the list, finding the max and adding values
    *------------------------------------------------------------------------------------*/

public class MyListOfInts {
	
	public int firstInt;
	public MyListOfInts restOfTheInts;
	
	public MyListOfInts(int f) {
		firstInt=f;
	}
	
	public MyListOfInts(int f, MyListOfInts r) {
		firstInt=f;
		restOfTheInts=r;
	}
	
	public MyListOfInts(MyListOfInts r) {
		this.firstInt = r.firstInt;
		
		if(r.restOfTheInts != null)
			this.restOfTheInts = new MyListOfInts(r.restOfTheInts);
	}
}

