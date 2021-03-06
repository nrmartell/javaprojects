   /*------------------------------------------------------------------------------------
    |  Name: Natalie Martell
    |  Date Modified 2/28/17	
    |  Purpose:  Program is designed to create a linked list from an input file
    |  user must be able ot perform specified operations including adding and removing 
    |  ids from list and writing to a different output file
    *------------------------------------------------------------------------------------*/


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Class implementing the AnalyzePOI functionality

public class AnalyzePOI {


//	  This function reads in the data from input file and returns a POIList if all data is successfully read otherwise is null object. 
//	  fileName : String
//	  POIList
//	  IOException: Thrown when BufferedReader is not able to read data
//	  FileNotFoundException: Thrown when input file is not found
	
	private static POIList readFile(String fileName) throws IOException {
		POIList list = new POIList();
		int cur = 0;

		FileReader fr;
		try {
			fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);

			String cLine;

			while((cLine = br.readLine()) != null) {
				long id;
				
				try {
					id = Long.parseLong(cLine);
				} catch (NumberFormatException e) {
					System.out.println("Expected ID in the file is not a long integer");
					br.close();
					return null;
				}
				
				String name = br.readLine();
				int threat;
				try {
					threat = Integer.parseInt(br.readLine());
				} catch (NumberFormatException e) {
					System.out.println("Threat level is not an integer");
					br.close();
					return null;
				}
				
				if(threat < 0 || threat > 5) {
					System.out.println("Threat level is not within expected range(0-5)");
					br.close();
					return null;
				}
				
				list.insertAt(cur++, id, name, threat);
			}
			
			fr.close();
			br.close();
			return list;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("File not found: " + fileName);
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Some error occurred in reading data from: " + fileName);
			return null;
		}
	}
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.print("Please provide the filename:");
			String inputFileName = br.readLine();
			POIList list = readFile(inputFileName);

			if(list == null) {
				while(true) {
					System.out.println("\nSome error occured in reading the file.");
					System.out.println("Please enter a file meeting required specifications.");
					
					System.out.print("\nPlease provide the filename of the input connection profile: ");
					inputFileName = br.readLine();
					list = readFile(inputFileName);
					
					if(list != null)
						break;
				}
			}

			System.out.println("\n Successfully read the file.");
			boolean flag = true;
			
			while(flag) {
				System.out.println("\nPlease select one of the following choice:");
				System.out.println("1. Print the linked list content on the terminal");
				System.out.println("2. Search a person in the linked list with ID or name");
				System.out.println("3. Insert a new person in a particular location index");
				System.out.println("4. Swap two people in two specific location indices");
				System.out.println("5. Remove a record containing a specific ID");
				System.out.println("6. Remove all records with a certain threat level");
				System.out.println("7. Write the content of the linked list in an output file");
				System.out.println("8. Quit program.");
				
				System.out.print("\nYour choice: ");
				String response = br.readLine();
				
				if(response.equals("1")) {
					list.printList();
				} else if(response.equals("2")) {
					System.out.print("\nEnter the name of person: ");
					String personName = br.readLine();
					System.out.print("\nEnter the ID: ");
					long id = Long.parseLong(br.readLine());
					
					POI result = list.searchPerson(personName, id);
					if(result == null) {
						System.out.println("\nPerson not found in the list");
					} else {
						System.out.println("\nPerson found in the list: \n" + result.toString());
					}
				} else if(response.equals("3")) {
					long id;
					int threatLevel, index;
					String name;
					
					while(true) {
						System.out.print("\nEnter the ID of the person: ");
						try {
							id = Long.parseLong(br.readLine());
						} catch (NumberFormatException e) {
							System.out.println("Incorrect format for ID(must be long integer). Try again!!");
							continue;
						}
						break;
					}
					
					System.out.print("Enter the name of the person: ");
					name = br.readLine();
					
					while(true) {
						System.out.print("\nEnter the threat level of person: ");
						try {
							threatLevel = Integer.parseInt(br.readLine());
						} catch (NumberFormatException e) {
							System.out.println("Threat level must be an integer between 0 and 5. Please retry!!");
							continue;
						}
						if(threatLevel < 0 || threatLevel > 5) {
							System.out.println("Threat level must be an integer between 0 and 5. Please retry!!");
							continue;
						}
						break;
					}

					while(true) {
						System.out.print("\nEnter the index at which to insert: ");
						try {
							index = Integer.parseInt(br.readLine());
						} catch (NumberFormatException e) {
							System.out.println("Index must be an integer. Please retry!!");
							continue;
						}
						break;
					}

					boolean result = list.insertAt(index, id, name, threatLevel);
					if(result) {
						System.out.println("\nSuccessfully inserted the information at given index.");
					} else {
						System.out.println("\nCould not insert the information at given index.");
					}
				} else if(response.equals("4")) {
					int idxA, idxB;
					
					while(true) {
						try {
							System.out.print("\nEnter first index: ");
							idxA = Integer.parseInt(br.readLine());
						} catch(NumberFormatException e) {
							System.out.println("This number must be an integer.Please retry!!");
							continue;
						}
						break;
					}
					
					while(true) {
						try {
							System.out.print("\nEnter second index: ");
							idxB = Integer.parseInt(br.readLine());
						} catch(NumberFormatException e) {
							System.out.println("This number must be an integer.Please retry!!");
							continue;
						}
						break;
					}

					boolean result = list.swap(idxA, idxB);
					if(result) {
						System.out.println("\nPersons with given indices have been swapped.");
					} else {
						System.out.println("\nCould not swap given indices.");
					}
				} else if(response.equals("5")) {
					long id;
					while(true) {
						System.out.print("\nEnter the ID of the person: ");
						try {
							id = Long.parseLong(br.readLine());
						} catch (NumberFormatException e) {
							System.out.println("Incorrect format for ID(must be long integer). Try again!!");
							continue;
						}

						boolean result = list.removeID(id);
						if(result) {
							System.out.println("\nPerson with given ID has been removed from the list.");
						} else {
							System.out.println("\nCould not find the given ID");
						}
						
						break;
					}
				} else if(response.equals("6")) {
					int threatLevel;
					while(true) {
						System.out.print("\nEnter the required threat level to be removed: ");
						try {
							threatLevel = Integer.parseInt(br.readLine());
						} catch (NumberFormatException e) {
							System.out.println("Threat level must be an integer between 0 and 5. Please retry!!");
							continue;
						}
						
						if(threatLevel < 0 || threatLevel > 5) {
							System.out.println("Threat level must be an integer between 0 and 5. Please retry!!");
							continue;
						}

						boolean result = list.removeThreat(threatLevel);
						if(result) {
							System.out.println("\nPerson with given threat level have been removed from the list.");
						} else {
							System.out.println("\nDid not find any person with given threat level.");
						}
						
						break;
					}
				} else if(response.equals("7")) {
					System.out.print("Please enter the name of file to which contents should be written: ");
					String outputFileName = br.readLine();
					
					boolean result = list.writeToFile(outputFileName);
					
					if(result) {
						System.out.println("\nContents have been written to " + outputFileName);
					} else {
						System.out.println("\nContents could not be written to " + outputFileName);
					}
				} else if(response.equals("8")) {
					flag = false;
					continue;
				} else {
					System.out.println("\n Incorrect choice");
					System.out.println("You can only select: 1/2/3/4/5/6/7/8\n");
				}
			}
			System.out.println("\nExiting now.");
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Error in reading file. The file probably does not exist");
			return;
		}
	}
}