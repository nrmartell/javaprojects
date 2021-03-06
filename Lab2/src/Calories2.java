
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Calories2 {

	//create global array variables for days of the week 
    static String daysOfWeek[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
	private static Scanner keyboard;

    public static void main(String[] args) throws FileNotFoundException {
    	
    	readFile();

    }
    
  //reads file from keyboard input from user
    public static void readFile(){
    	
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
        // Number of rows will be 7, columns will be based on input file data
        // as soon as lines are read.
        int[][] weeklyCalories = new int[7][];
        int maxMeals = 0;

        for (int day = 0; day < 7; day++) {
            // Checking if there is a next line or not
            // dont know how many lines there are yet.
            if (inFile.hasNextLine()) {
                String dayCalories = inFile.nextLine();
                String[] arrCalories = dayCalories.split(" ");
                // continue with any amount of entries. Then assign memory to array accordingly.
                int mealsThatDay = arrCalories.length;
                if (mealsThatDay > maxMeals)
                    maxMeals = mealsThatDay;
                weeklyCalories[day] = new int[mealsThatDay];

                // Assigning the values to respective positions
                for (int meal = 0; meal < mealsThatDay; meal++) {
                    weeklyCalories[day][meal] = Integer.parseInt(arrCalories[meal]);
                }
            } else {
                System.out.println("Error: Data is not provided for " + daysOfWeek[day] + ". Quiting the program.");
                return;
            }
        }
     // If there is an extra line, more data in file than formatted for, should throw exception.
        if (inFile.hasNextLine()) {
            System.out.println("Error: Data is provided for more than 7  days. Quiting the program.");
            return;
        }
        keyboard.close();// close keyboard input
        inFile.close();//close scanner
      

        getDailyCalories(weeklyCalories);
        System.out.println();
        getAverageDailyCalories(weeklyCalories);
        System.out.println();
        getAverageCaloriesPerMeal(weeklyCalories, maxMeals);
        System.out.println();
        getMaxDailyCalories(weeklyCalories);
        System.out.println();
        getMaxMealCalories(weeklyCalories, maxMeals);
        System.out.println();

    	
    }

    // Prints daily total calories
    public static void getDailyCalories(int[][] weeklyCalories) {
        for (int i = 0; i < weeklyCalories.length; i++) {
            // create dailyCalories variable
            int dailyCalories = 0;

            for (int meal = 0; meal < weeklyCalories[i].length; meal++) {
                dailyCalories += weeklyCalories[i][meal];
            }

            System.out.println("Daily Total Calories For " + (daysOfWeek[i]) + " is " + dailyCalories);
        }
    }

    // Prints the average daily calorie consumption
    public static void getAverageDailyCalories(int[][] weeklyCalories) {
        for (int i = 0; i < weeklyCalories.length; i++) {
            int dailyCalories = 0;

            for (int meal = 0; meal < weeklyCalories[i].length; meal++) {
                dailyCalories += weeklyCalories[i][meal];
            }

            float averageCalories = (float) dailyCalories / weeklyCalories[i].length;

            System.out.println("Daily Average Calories For " + (daysOfWeek[i]) + " is " + averageCalories);
        }

    }

    // Prints the average Calorie Per meal.
    public static void getAverageCaloriesPerMeal(int[][] weeklyCalories, int maxCalories) {
        for (int i = 0; i < maxCalories; i++) {

            int mealCalories = 0;
            int mealDays = 0;
            // Calculating total calories for meal.
            for (int j = 0; j < weeklyCalories.length; j++) {
                if (weeklyCalories[j].length >= (i + 1)) {
                    mealCalories += weeklyCalories[j][i];
                    mealDays++;
                }
            }
            float AverageMealCalories = (float) mealCalories / mealDays;

            System.out.println("Daily Calorie Average Meal " + (i + 1) + ":  is " + AverageMealCalories);
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
    public static void getMaxMealCalories(int[][] weeklyCalories, int maxMeals) {

        for (int i = 0; i < maxMeals; i++) {

            int maxMealCalories = Integer.MIN_VALUE;
            for (int j = 0; j < weeklyCalories.length; j++) {
                if (weeklyCalories[j].length >= (i + 1)) {
                    if (maxMealCalories < weeklyCalories[j][i]) {
                        maxMealCalories = weeklyCalories[j][i];
                    }
                }
            }
            System.out.println("Meal " + (i + 1) + ": Max Calories consumed this week " + maxMealCalories);
        }
    }
}