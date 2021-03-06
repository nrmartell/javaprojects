   /*------------------------------------------------------------------------------------
    |  Name: Natalie Martell
    |  Date Modified 2/28/17	
    |  Purpose:  Program is designed to create a linked list from an input file
    |  user must be able ot perform specified operations including adding and removing 
    |  ids from list and writing to a different output file
    *------------------------------------------------------------------------------------*/




//Class implementing POI.

public class POI {

	// Class instance variables
	private long id;
	private String name;
	private int threatLevel;
	
	public POI next;
	
	//Initializes the POI object 
	
	public POI() {
		this.id = 0; this.name = new String(); this.threatLevel = -1;
		this.next = null;
	}
	
	// Initializes the POI object with given values.
	 // id	: Long
	 // name: String
	 // tl	: int
	
	public POI(long id, String name, int tl) {
		this.id = id; this.name = name; this.threatLevel = tl;
		this.next = null;
	}

	// Getter and Setters
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public String toString() {
		return this.id + "\n" + this.name + "\n" + this.threatLevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getThreatLevel() {
		return threatLevel;
	}

	public void setThreatLevel(int threatLevel) {
		this.threatLevel = threatLevel;
	}
}