   /*------------------------------------------------------------------------------------
    |  Name: Natalie Martell
    |  Date Modified 2/28/17	
    |  Purpose:  Program is designed to create a linked list from an input file
    |  user must be able to perform specified operations including adding and removing 
    |  ids from list and writing to a different output file
    *------------------------------------------------------------------------------------*/



import java.io.FileWriter;
import java.io.IOException;

//Class implementing the POIList.

public class POIList {
	
	private POI head;
	int length;
	
	
	public POIList() {
		this.head = null;
		this.length = 0;
	}

	 //This function prints the sequence of person in list 
	 
	public void printList() {
		if(this.length == 0) {
			System.out.println("\nThe list is empty.");
			return;
		}
		POI cur = this.head;
		
		while(cur != null) {
			System.out.println(cur.toString());
			cur = cur.next;
		}
	}

	
//	  This function is used to insert a new POI in the linked list at a
//	 given index. It returns true if the POI node is successfully inserted, else false.
	 
//	 *  index: integer
//	 *  id	 : long
//	 *  name : String
//	 *  tl	 : integer
//	 * 	Boolean
	
	public boolean insertAt(int index, long id, String name, int tl) {
		if(index < 0 || index > this.length)
			return false;
		else {
			if(index == 0) {
				POI newPOI = new POI(id, name, tl);

				newPOI.next = this.head;
				this.head = newPOI;
				this.length++;
				
			} else if(index == this.length) {
				POI cur = this.head;

				while(cur.next != null) {
					cur = cur.next;
				}

				POI newPOI = new POI(id, name, tl);
				cur.next = newPOI;
				this.length++;
			} else {
				
				int idx = 0;
				POI cur = this.head;
				while(idx != index-1) {
					cur = cur.next;
					idx++;
				}
				
				POI newPOI = new POI(id, name, tl);
				POI nextPOI = cur.next;
				cur.next = newPOI;
				newPOI.next = nextPOI;
				this.length++;
			}
			return true;
		}
	}

//	
//	  This function searches a Person by input name or id and returns the
//	  first match. If no match is found then it returns null. 
//	  param name : String
//	  id	: long
//	  return	POI
	
	public POI searchPerson(String name, long id) {
		POI result = null;
		POI cur = this.head;
		
		while(cur != null) {
			if(cur.getId() == id || name.equals(cur.getName())) {
				result = cur;
				break;
			}
			cur = cur.next;
		}
		
		return result;
	}

//	
//	  This function removes a person with input id from the POIList. If the
//	  person is removed from the list then the function returns true else false.
//	 id	: long
//	 Boolean
//	
	public boolean removeID(long id) {
		boolean flag = false;
		POI prev = null, cur = this.head;
		
		// Keep on iterating until required id is found
		while(cur != null) {
			if(cur.getId() == id) {
				break;
			} else {
				prev = cur;
				cur = cur.next;
			}
		}
		
		if(cur != null) {
			//found person id that needs to be removed
			flag = true;

			// If cur is not the head of the list
			if(prev != null) {
				POI next = cur.next;
				cur = null;
				prev.next = next;
			} else {
				this.head = this.head.next;
				cur = null;
			}
		}
		return flag;
	}


//	  This function removes all person from the POIList with given
//	  threat level. It returns true if even one person is removed
//	  else false. 
//	  level	: integer
//	  return Boolean

	public boolean removeThreat(int level) {
		boolean flag = false;
		POI prev = null, cur = this.head;

		// Iterate until the last element
		while(cur != null) {
			if(cur.getThreatLevel() == level) {
				flag = true;

				// If cur is not head
				if(prev != null) {
					POI temp = cur.next;
					cur = null;
					prev.next = temp;
					cur = temp;
				} else {
					POI temp = cur.next;
					cur = null;
					this.head = temp;
					cur = this.head;
					prev = null;
				}
			} else {
				prev = cur;
				cur = cur.next;
			}
		}
		return flag;
	}
	

//	  This function is used to swap two persons given by the input
//	  indices (in the POIList). It returns boolean value denoting
//	  whether swap was successful or not.

//	 indexA	; integer
//	 indexB	: integer
//	 return Boolean

	public boolean swap(int indexA, int indexB) {
		if(indexA < 0 || indexA >= this.length)
			return false;

		if(indexB < 0 || indexB >= this.length)
			return false;

		POI prevA = null, curA = this.head;
		int idxA = 0;

		while(idxA != indexA) {
			prevA = curA;
			curA = curA.next;
			idxA++;
		}

		POI prevB = null, curB = this.head;
		int idxB = 0;

		while(idxB != indexB) {
			prevB = curB;
			curB = curB.next;
			idxB++;
		}

//		System.out.println(curA.toString());
//		System.out.println(prevA);
//		
//		System.out.println(curB.toString());
//		System.out.println(prevB);
		
		// If curA is not head of linked list
        if (prevA != null)
            prevA.next = curB;
        else //make curB the new head
            this.head = curB;

        // If curB is not head of linked list
        if (prevB != null)
            prevB.next = curA;
        else // make curA the new head
            this.head = curA;

        // Swap next pointers
        POI temp = curA.next;
        curA.next = curB.next;
        curB.next = temp;

        return true;
	}


//	  This function is used to write the content of POIList in the given file.
//	  It returns true if all the POI objects are successfully written to the file. 
//	  fileName	: String
//	 return Boolean

	public boolean writeToFile(String fileName) {
		try {
			FileWriter fw = new FileWriter(fileName);
			
			POI cur = this.head;
			
			while(cur != null) {
				fw.write(Long.toString(cur.getId()) + "\n");
				fw.write(cur.getName() + "\n");
				fw.write(cur.getThreatLevel() + "\n");
				
				cur = cur.next;
			}
			
			fw.close();
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Error occured in file writing");
			return false;
		}
		
		return true;
	}
}