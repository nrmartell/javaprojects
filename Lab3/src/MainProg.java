   /*------------------------------------------------------------------------------------
    |  Name: Natalie Martell
    |  Date Modified 2/14/17	
    |  Purpose:  Program is designed to help a company ship basketballs. 
    |  Program will take input from a text file with box dimensions and radii
    |  and then use that data to determine which boxes to use on each size of basketball
    *------------------------------------------------------------------------------------*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class MainProg {
	
	private final static int maxBoxAllowed = 25;
	private final static int maxBallAllowed = 25;
	

	  
//	   arrayBall  : Array of Basketball objects
//	   ballsAdded : Total number of basketballs added
//	   arrayBox	 : Array of BoxType objects
//	   boxesAdded : Total number of different BoxType
	
	private static void fitBallsIntoBoxes(Basketball[] arrayBall, int ballsAdded,
			BoxType[] arrayBox, int boxesAdded) {
		
		// This boolean array to see if a ball has been fit into any of the boxes.
		// Elements in this array are initialized to false.
		Boolean[] ballFit = new Boolean[ballsAdded];
		Arrays.fill(ballFit, false);	// Filling all the values with false
		
		// This boolean array is used to know if a box has been used to fit any of the balls.		 
		// All elements in this array are initialized to false.
		
		Boolean[] boxUsed = new Boolean[boxesAdded];
		Arrays.fill(boxUsed, false);	// Fill all the values with false
		
		// Used to count the number of balls that can fit and boxes used
		int cntBallsFit = 0, cntBoxesUsed = 0;
		
		// check for each of the balls
		for(int i = 0; i < ballsAdded; i++) {
			
			int minindex = -1;
			double minSpaceLeft = Double.MAX_VALUE;
			Basketball ball = arrayBall[i];
			
			// Try all boxes that we have
			for(int j = 0; j < boxesAdded; j++) {
				BoxType box = arrayBox[j];
				
				// balls can be fit into this box
				if(box.fitsInBoxType(ball)) {
					double spcLeft = box.emptySpace(ball);
					
					// Now compare space
					if(spcLeft < minSpaceLeft) {
						minSpaceLeft = spcLeft;
						minindex = j;
					}
				}
			}
			
			// If have found at least one type of box which can fit the ball
			if (minindex != -1) {
				
				cntBallsFit++;		// increment balls fit count if ball fits
				
				if(boxUsed[minindex] == false)
					cntBoxesUsed++;		// increment boxes used 
				
				boxUsed[minindex] = true;
				ballFit[i] = true;
				
				// Best box for this ball has index : minindex
				System.out.println("\nBall number: " + (i+1) + " can be fit into "
						+ " box number: " + (minindex+1));
				System.out.println("Volume of box: " + 	String.format("%.2f", arrayBox[minindex].getVolume())
						+ " Volume of ball: " + String.format("%.2f", ball.getVolume())
						+ " Remaining space: " + String.format("%.2f", arrayBox[minindex].emptySpace(ball)));
			} else {
				System.out.println("\nBox not available for this basketball having volume: " +
							String.format("%.2f", ball.getVolume()));
			}
		}
		
		System.out.println("\nTotal number of basketballs that could be fit"
				+ " into available boxes: " + cntBallsFit);
		
		if(ballsAdded - cntBallsFit > 0)
			System.out.println("\nList of basketball radii that could"
					+ " not be fit into any of the boxes:");
		
		// Print list of balls that could be added to any of the boxes
		for(int i = 0; i < ballsAdded; i++)
		{
			if(ballFit[i] == false)
			{
				System.out.print(arrayBall[i].getRadius() + " ");
			}
		}
		System.out.println();
		
		if(boxesAdded - cntBoxesUsed > 0)
			System.out.println("\nList of boxes that were left unused:");
		
		// Print of boxes that were left unused
		for(int i = 0; i < boxesAdded; i++)
		{
			BoxType box = arrayBox[i];
			
			if(boxUsed[i] == false)
			{
				System.out.println("Box number: " + (i+1) +
						" with size: " + box.getLength() + "(Length), " +
						box.getWidth() + "(Width), " + box.getHeight() + "(Height)");
			}
		}
	}
	


	public static void main(String[] args){
		
		
		BufferedReader keyboard, br;
		
		// Using a BufferedReader object to read lines
		keyboard = new BufferedReader(new InputStreamReader(System.in));
		
        String fileName;
        FileReader fileReader;
        
        try {
			System.out.print("Enter the name of the file: ");
			fileName = keyboard.readLine();
			
			fileReader = new FileReader(fileName);
			
			// Array for BoxTypes
			BoxType[] arrayBox = new BoxType[maxBoxAllowed];
			
			// Array for the BasketBalls
			Basketball[] arrayBall = new Basketball[maxBallAllowed];
			
			// Using a BufferedReader object to read lines
			br = new BufferedReader(fileReader);
			
			String sLine;
			
			// Current indexes where new ball and box dimensions will be stored
			int boxesAdded = 0, ballsAdded = 0;
			
			while((sLine = br.readLine()) != null)
			{
				// parse the line
				String[] splited = sLine.split("\\s+");
				
				//if row length is 3 means we have a box
				if (splited.length == 3)
				{
					// found a box's dimensions
					double length = Double.parseDouble(splited[0]);
					double width  = Double.parseDouble(splited[1]);
					double height = Double.parseDouble(splited[2]);
					arrayBox[boxesAdded] = new BoxType(length, width, height);
					boxesAdded++;
				}
				//if row length is 1, we have a ball(radius)
				else if (splited.length == 1)
				{
					// found a ball
					double radius  = Double.parseDouble(splited[0]);
					arrayBall[ballsAdded] = new Basketball(radius);
					ballsAdded++;
				}
				else
				{
					System.out.println("Did not get 3 or 1 value on this line: " + sLine);
				}
			}
			
			// To check if read file correctly
			System.out.println("Total boxes found: " + boxesAdded);
			System.out.println("Total balls found:" + ballsAdded);
			
			//  fit the balls into boxes
			fitBallsIntoBoxes(arrayBall, ballsAdded, arrayBox, boxesAdded);
			
		} catch (FileNotFoundException e1) {
            System.out.println("Incorrect File Name Entered, Cant Find File");
			e1.printStackTrace();
		} catch (IOException e) {
			System.out.println("Some other exception happened with file handling");
			e.printStackTrace();
		}
	}
}