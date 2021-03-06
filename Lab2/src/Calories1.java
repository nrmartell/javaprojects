import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Calories1 {
	
	//create array variables for days of the week and meals
    static String daysOfWeek[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    static String Meals[] = {"Breakfast", "Lunch", "Dinner"};
	private static Scanner keyboard;

    
	public static void main(String[] args) throws FileNotFoundException {

       readFile();
    }
    
	//reads file from keyboard input from user
    public static void readFile(){
    	keyboard = new Scanner(System.in);
        System.out.print("Enter the name of the file: ");
        String fileName = keyboard.nextLine();

        // Reading data from the input file.
        Scanner inFile = null;
        try {
            inFile = new Scanner(new FileInputStream(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Incorrect File Name Entered, Can't Find File");
            e.printStackTrace();
        }

        // Number of rows will be 7, columns will 3.
        int[][] weeklyCalories = new int[7][3];

        for (int day = 0; day < 7; day++) {
             // Checking if there is a next line or not
            // unknown number of lines right now
            if (inFile.hasNextLine()) {
                String dayCalories = inFile.nextLine();
                String[] arrCalories = dayCalories.split(" ");
                // should continue only if 3 entries are there for a line, if not should throw error.
                if (arrCalories.length == 3) {

                    // Assigning the values to array
                    weeklyCalories[day][0] = Integer.parseInt(arrCalories[0]);
                    weeklyCalories[day][1] = Integer.parseInt(arrCalories[1]);
                    weeklyCalories[day][2] = Integer.parseInt(arrCalories[2]);
       
                    		

                    // if columns are less than three error should be thrown
                } else if(arrCalories.length <3 )  {
                    System.out.println(
                            "Error: Data provided for " + daysOfWeek[day] + " is incorrect. Quiting the program.");
                    return;
                }
                // if rows are not equal to seven error should be thrown
            } else if(weeklyCalories[day].length != 7) {
                System.out.println("Error: Data is not provided for " + daysOfWeek[day] + ". Quiting the program.");
                return;
            }
        }
        // If there is an extra line, more data in file than formatted for, should throw exception.
        if (inFile.hasNextLine()) {
            System.out.println("Error: Data is provided for more than 7  days. Quiting the program.");
            return;
        }

        inFile.close(); // close scanner
        keyboard.close(); // close keyboard input

        
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

    // Prints daily total calories
    public static void getDailyCalories(int[][] weeklyCalories) {
        for (int i = 0; i < weeklyCalories.length; i++) {
            // create dailyCalories variable
            int dailyCalories = weeklyCalories[i][0] + weeklyCalories[i][1] + weeklyCalories[i][2];

            System.out.println("Daily Total Calories For " + (daysOfWeek[i]) + " is " + dailyCalories);
        }
    }

    // Prints the average daily calorie consumption
    public static void getAverageDailyCalories(int[][] weeklyCalories) {
        for (int i = 0; i < weeklyCalories.length; i++) {
            int dailyCalories = weeklyCalories[i][0] + weeklyCalories[i][1] + weeklyCalories[i][2];
            int averageCalories =  dailyCalories / 3;

            System.out.println("Daily Average Calories For " + (daysOfWeek[i]) + " is " + averageCalories);
        }

    }


    // Prints the average Calorie Per meal.
    public static void getAverageCaloriesPerMeal(int[][] weeklyCalories) {
        for (int i = 0; i < weeklyCalories[0].length; i++) {
            int MealCalories = weeklyCalories[0][i] + weeklyCalories[1][i] + weeklyCalories[2][i] + weeklyCalories[3][i]
                    + weeklyCalories[4][i] + weeklyCalories[5][i] + weeklyCalories[6][i];

            int AverageMealCalories = MealCalories / 7;

            System.out.println("Daily Calorie Average " + (Meals[i]) + " " + " is " + AverageMealCalories);
        }
    }

    // Prints max calories consumed each day.
    public static void getMaxDailyCalories(int[][] weeklyCalories) {
        for (int i = 0; i < weeklyCalories.length; i++) {
            int maxCalories = Integer.MIN_VALUE;

            for (int j = 0; j < weeklyCalories[i].length; j++) {

                if (weeklyCalories[i][j] > maxCalories)
                    maxCalories = weeklyCalories[i][j];
            }
            System.out.println(daysOfWeek[i] + " : Max Calories consumed = " + maxCalories);
        }
    }

    // Prints max calories consumed in each meal
    public static void getMaxMealCalories(int[][] weeklyCalories) {

        for (int i = 0; i < weeklyCalories[0].length; i++) {

            int maxMealCalories = weeklyCalories[0][i];
            for (int j = 0; j < weeklyCalories.length; j++) {

                if (weeklyCalories[j][i] > maxMealCalories) {
                    maxMealCalories = weeklyCalories[j][i];
                }
            }
            System.out.println(Meals[i] + " Max Calories consumed this week " + maxMealCalories);
        }
    }
}