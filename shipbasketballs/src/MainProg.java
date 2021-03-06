
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainProg {
	
	private final static int maxBoxAllowed = 25;
	private final static int maxBallAllowed = 25;
	
	// Keyboard is used to read from System.in and br is used to read from file
	private static BufferedReader keyboard, br;
	private static FileReader fileReader;
	
	public static void main(String[] args){
//		readFile();
		BoxType boxObject = new BoxType();
		boxObject.getVolume();
		
		
		// Using a BufferedReader object to read lines
				keyboard = new BufferedReader(new InputStreamReader(System.in));
				
				// Stores the dimensions of the box
				double[][] boxData = new double[maxBoxAllowed][3];
				
				// Stores the dimensions of the bal
				double[] ballData = new double[maxBallAllowed];
				
		        String fileName;
				try {
					System.out.print("Enter the name of the file: ");
					fileName = keyboard.readLine();
					
					fileReader = new FileReader(fileName);
					
					// Using a BufferedReader object to read lines
					br = new BufferedReader(fileReader);
					
					String sLine;
					
					// Current indices where new ball and box dimensions will be stored
					int boxesAdded = 0, ballsAdded = 0;
					
					while((sLine = br.readLine()) != null)
					{
						// Now we will parse the line
						String[] splited = sLine.split("\\s+");
						
						// Printing the read line to the console..comment later
						System.out.println(sLine);
						//System.out.println(splited.length);
						
						if (splited.length == 3)
						{
							// We found a box's dimensions
							boxData[boxesAdded][0] = Double.parseDouble(splited[0]);
							boxData[boxesAdded][1] = Double.parseDouble(splited[1]);
							boxData[boxesAdded][2] = Double.parseDouble(splited[2]);
							boxesAdded++;
						}
						else if (splited.length == 1)
						{
							// We found a ball
							ballData[ballsAdded]  = Double.parseDouble(splited[0]);
							ballsAdded++;
						}
						else
						{
							System.out.println("Did not get 3 or 1 value on this line: " + sLine);
						}
					}
					
					// To check if we read correctly..Comment these lines later
					System.out.println("Total boxes found: " + boxesAdded);
					System.out.println("Total balls found:" + ballsAdded);
					
				} catch (FileNotFoundException e1) {
		            System.out.println("Incorrect File Name Entered, Cant Find File");
					e1.printStackTrace();
				} catch (IOException e) {
					System.out.println("Some other exception happened with file handling");
					e.printStackTrace();
				}
	}

//	public static void readFile(){
//		// Using a BufferedReader object to read lines
//		keyboard = new BufferedReader(new InputStreamReader(System.in));
//		
//		// Stores the dimensions of the box
//		double[][] boxData = new double[maxBoxAllowed][3];
//		
//		// Stores the dimensions of the bal
//		double[] ballData = new double[maxBallAllowed];
//		
//        String fileName;
//		try {
//			System.out.print("Enter the name of the file: ");
//			fileName = keyboard.readLine();
//			
//			fileReader = new FileReader(fileName);
//			
//			// Using a BufferedReader object to read lines
//			br = new BufferedReader(fileReader);
//			
//			String sLine;
//			
//			// Current indices where new ball and box dimensions will be stored
//			int boxesAdded = 0, ballsAdded = 0;
//			
//			while((sLine = br.readLine()) != null)
//			{
//				// Now we will parse the line
//				String[] splited = sLine.split("\\s+");
//				
//				// Printing the read line to the console..comment later
//				System.out.println(sLine);
//				//System.out.println(splited.length);
//				
//				if (splited.length == 3)
//				{
//					// We found a box's dimensions
//					boxData[boxesAdded][0] = Double.parseDouble(splited[0]);
//					boxData[boxesAdded][1] = Double.parseDouble(splited[1]);
//					boxData[boxesAdded][2] = Double.parseDouble(splited[2]);
//					boxesAdded++;
//				}
//				else if (splited.length == 1)
//				{
//					// We found a ball
//					ballData[ballsAdded]  = Double.parseDouble(splited[0]);
//					ballsAdded++;
//				}
//				else
//				{
//					System.out.println("Did not get 3 or 1 value on this line: " + sLine);
//				}
//			}
//			
//			// To check if we read correctly..Comment these lines later
//			System.out.println("Total boxes found: " + boxesAdded);
//			System.out.println("Total balls found:" + ballsAdded);
//			
//		} catch (FileNotFoundException e1) {
//            System.out.println("Incorrect File Name Entered, Cant Find File");
//			e1.printStackTrace();
//		} catch (IOException e) {
//			System.out.println("Some other exception happened with file handling");
//			e.printStackTrace();
//		}
//	}
	
}