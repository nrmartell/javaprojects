   /*------------------------------------------------------------------------------------
    |  Name: Natalie Martell
    |  Date Modified 4/23/17
	|  Purpose:  Program is designed to create a stack and linked list to evaluate a postfix
	| expression
    *------------------------------------------------------------------------------------*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.io.IOException;

public class Evaluator {

	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter filename: ");
		String filename;
		
		//Inputing the filename
	    filename = in.nextLine();
	    in.close();
	    
	    //Declaring a new GenericStack which we are using for postfix evaluation
	    GenericStack calc = new GenericStack();
	    
		// Construct BufferedReader from FileReader
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/" + filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
		String line = null;
		
		//Reading the file line by line
		while ((line = br.readLine()) != null) {
			
			//Clearing the stack
			calc.popAll();
			
			//To check for invalid expressions
			int flag = 0;
			
			//Converting the string into an array of tokens
			String[] tokens = line.split(" "); 
			
			int x = 0;
		    int y = 0;
		    int r = 0;
		    
			for(int i=0; i<tokens.length; i++){
			    
			    //Else do the operation according and store the result in the stack
			    if(tokens[i].equals("+")){
			    	
			    	//checking is stack is empty or has only one operand
			    	if(calc.getSize() <= 1){
			    		
			    		//set flag = 1 to indicate an invalid expression and break
			    		flag = 1;
			    		break;
			    	}	
			    	else{
				        x = (int) calc.pop();
				        y = (int) calc.pop();
				        r = x+y;
				        calc.push(r);
			    	}
			    }
			    
			    else if(tokens[i].equals("-")){
			    	
			    	//checking if stack is empty or has only one operand
			    	if(calc.getSize() <= 1){
			    		
			    		//set flag = 1 to indicate an invalid expression and break
			    		flag = 1;
			    		break;
			    	}
			    	else{
				        x = (int) calc.pop();
				        y = (int) calc.pop();
				        r = y-x;
				        calc.push(r);
			    	}
			    }
			    
			    else if(tokens[i].equals("*")){
			    	
			    	//checking is stack is empty or has only one operand
			    	if(calc.getSize() <= 1){
			    		
			    		//set flag = 1 to indicate an invalid expression and break
			    		flag = 1;
			    		break;
			    	}
			    	else{
				        x = (int) calc.pop();
				        y = (int) calc.pop();
				        r = x*y;
				        calc.push(r);
			    	}
			    }
			    
			    else if(tokens[i].equals("/")){
			    	
			    	//checking is stack is empty or has only one operand
			    	if(calc.getSize() <= 1){
			    		
			    		//set flag = 1 to indicate an invalid expression and break
			    		flag = 1;
			    		break;
			    	}
			    	else{
				        x = (int) calc.pop();
				        y = (int) calc.pop();
				        r = y/x;
				        calc.push(r);
			    	}
			    }
			    
			    //If the token is a digit then push it to stack
			    else{
			        calc.push(Integer.parseInt(tokens[i]));
			    }
				
			}
			
			if(flag == 1){
				System.out.println(line + " is an invalid expression!");
	    	}
			else{
				int answer = (int) calc.pop();
				//checking if the stack is empty
				if(calc.isEmpty())
					System.out.println(line + " = " + answer);
				else
					System.out.println(line + " is an incomplete expression!");
			}
			
		}
	 
		br.close();

	}
}