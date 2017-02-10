package MainProg;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
	
	public class MainProg {
	private static Scanner keyboard;

	public static void main(String[] args) {
		keyboard = new Scanner(System.in);
		System.out.print("Enter the name of the file: ");
		String fileName = keyboard.nextLine();

		// Reading Data from the input file.
		Scanner inFile = null;
		try {
			inFile = new Scanner(new FileInputStream(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("Incorrect File Name Entered, Cant Find File");
			e.printStackTrace();
		}

		ArrayList<String> dimensions = new ArrayList<String>();
		ArrayList<String> radii = new ArrayList<String>();
		while (inFile.hasNextLine()) {
			String line = inFile.nextLine();
			String[] n = line.split(" ");
			if (n.length == 1) {
				radii.add(n[0]);
			} else {
				dimensions.add(line);
			}
		}

		String[] dimArr = new String[dimensions.size()];
		dimArr = dimensions.toArray(dimArr);

		String[] radArr = new String[radii.size()];
		radArr = radii.toArray(radArr);

		for (String s : dimArr)
			System.out.println(s);
	
		for (String s : radArr)
			System.out.println(s);
	}
	
//	public double Basketball() {
//		// TODO Auto-generated constructor stub
//	}
}