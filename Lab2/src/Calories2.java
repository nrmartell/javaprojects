import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

	public class Calories2 {
		public static void main(String[] args) throws FileNotFoundException {

	    	readFileName();

	    }

	    public static void readFileName()  {

	    	Scanner keyboard = new Scanner(System.in); System.out.print("Enter the name of the file: ");
	    	String fileName = keyboard.nextLine();
	    	Scanner inFile = null;
			try {
				inFile = new Scanner(new FileInputStream(fileName));
			} catch (FileNotFoundException e) {
				System.out.println("Incorrect File Entered, Cant Find File");
				e.printStackTrace();
			}

	        
	        String MondayString = inFile.nextLine();


	        String Monday[] = MondayString.split(" ");

	        int n = Monday.length;


	        int [][] weeklyCalories = new int [7][n];

	        for (int i = 0; i < n; i++) {
	            weeklyCalories[0][i] = Integer.parseInt(Monday[i]);
	        }

	        String tuesdayString = inFile.nextLine();
	        String Tuesday[] = tuesdayString.split(" ");

	        for (int i = 0; i < n; i++) {
	            weeklyCalories[1][i] = Integer.parseInt(Tuesday[i]);
	        }

	        String wednesdayString = inFile.nextLine();
	        String Wednesday[] = wednesdayString.split(" ");

	        for (int i = 0; i < n; i++) {
	            weeklyCalories[2][i] = Integer.parseInt(Wednesday[i]);
	        }
	        
	        
	        String thursdayString = inFile.nextLine();
	        String Thursday[] = thursdayString.split(" ");

	        for (int i = 0; i < n; i++) {
	            weeklyCalories[3][i] = Integer.parseInt(Thursday[i]);
	        }
	        
	        String fridayString = inFile.nextLine();
	        String Friday[] = fridayString.split(" ");

	        for (int i = 0; i < n; i++) {
	            weeklyCalories[4][i] = Integer.parseInt(Friday[i]);
	        }

	        String saturdayString = inFile.nextLine();
	        String Saturday[] = saturdayString.split(" ");

	        for (int i = 0; i < n; i++) {
	            weeklyCalories[5][i] = Integer.parseInt(Saturday[i]);
	        }
	        
	        String sundayString = inFile.nextLine();
	        String Sunday[] = sundayString.split(" ");

	        for (int i = 0; i < n; i++) {
	            weeklyCalories[6][i] = Integer.parseInt(Sunday[i]);
	        }
	        
	      
	        
	        inFile.close(); 
	        keyboard.close();
	        
	     
	        getDailyCalories(weeklyCalories);
	        System.out.println();
	        getAverageDailyCalories(weeklyCalories);
	        System.out.println();
	        getAverageCaloriesPerMeal(weeklyCalories);
	        System.out.println();
	        getMaxDailyCalories(weeklyCalories);
	        System.out.println();
	        getMaxMealCalories(weeklyCalories);
	        System.out.println();
	        
	    }

	    public static void checkArraySize(int[][] weeklyCalories){
	    	for (int i = 0; i < weeklyCalories[0].length; i++) {
	    		
	    		for (int j = 0; j < weeklyCalories.length; j++){
	    			
	    			if(weeklyCalories.length < 3){
	    				System.out.println("Array is too small");
	    				
	    			}
	    			
	    		}
	    		
	    	}
	    }
	    public static void getDailyCalories(int[][] weeklyCalories) {
	        for (int i = 0; i < weeklyCalories.length; i++) {
	            // create dailyCalories variable 
	            int dailyCalories = weeklyCalories[i][0] + weeklyCalories[i][1] + weeklyCalories[i][2];
	            String daysOfWeek [] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
	            System.out.println("Daily Total Calories For "  + (daysOfWeek[i])+ " is " + dailyCalories);
	        }
	    }

	    // Prints the average daily calorie consumption
	    public static void getAverageDailyCalories(int [][] weeklyCalories) {
	        for (int i = 0; i < weeklyCalories.length; i++) {
	        	int dailyCalories = weeklyCalories[i][0] + weeklyCalories[i][1] + weeklyCalories[i][2];
	            String daysOfWeek [] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
	        	int averageCalories = dailyCalories/weeklyCalories[0].length;
	        	System.out.println("Daily Average Calories For "  + (daysOfWeek[i])+ " is " + averageCalories);
	        }


	    }
	    
	    public static void getAverageCaloriesPerMeal(int [][] weeklyCalories) {
	        for (int i = 0; i < weeklyCalories[0].length; i++) {        	
	            int MealCalories = weeklyCalories[0][i] + weeklyCalories[1][i] + weeklyCalories[2][i] + weeklyCalories[3][i] + weeklyCalories[4][i] +  weeklyCalories[5][i] +   weeklyCalories[6][i];
	            int AverageMealCalories = MealCalories/7;
        	
		            System.out.println("Daily Calorie Average for Meal "+ (i + 1)  + " " + " is " + AverageMealCalories);
	        	}
	         }

	    public static void getMaxDailyCalories(int [][] weeklyCalories) {
	    	for (int i = 0; i < weeklyCalories.length; i++) {
	    		int maxCalories = Integer.MIN_VALUE;
              
	            String daysOfWeek [] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
	            for (int j = 0; j < weeklyCalories[i].length; j++){
	                	 
	                    if (weeklyCalories[i][j] > maxCalories)
	                        maxCalories = weeklyCalories[i][j];
	            }
	                System.out.println( daysOfWeek[i] + " Max Calories consumed " + maxCalories);
	         }
	    }

	    public static void getMaxMealCalories(int [][] weeklyCalories) {
	        	for (int i = 0; i < weeklyCalories[0].length; i++) { 
	                int maxMealCalories = weeklyCalories[0][i];
	                for (int j = 0; j < weeklyCalories.length; j++){ 
	                    if (weeklyCalories[j][i] > maxMealCalories){
	                        maxMealCalories = weeklyCalories[j][i];
	                }
	             }
	             System.out.println("Meal "+ (i +1) + " Max Calories consumed this week "+ maxMealCalories );
	    }
	        
	        
	        
	        
	        
	        
	}
}
	        
	        
	    	




	

