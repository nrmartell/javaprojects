import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileReader;

public class demo {

	public static void main(String[] args) throws IOException {

		
		
//	    FileReader fr = new FileReader("info.txt");
//		BufferedReader br = new BufferedReader(fr);
//	    String currentLine;
//	    String completeFile = " ";
//	    while ((currentLine = br.readLine()) != null){
//	    	currentLine = br.readLine();
//	    	System.out.println(currentLine);
//	    }
//	}
//  }

		   
		FileReader fr = new FileReader("info.txt");
		BufferedReader br = new BufferedReader(fr);
		   String currentLine = "";
		    String completeFile = "";
	    for(int i =0; i<3; i++)
	    {
	    	currentLine += br.readLine();
	    	completeFile = completeFile + currentLine;

			   
	    	
	    }
	    System.out.println(currentLine);

	
	}
	


}
