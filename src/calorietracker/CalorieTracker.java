package calorietracker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Thumbone1
 */
public class CalorieTracker {
    
    private Reader reader;
    private int numDays;
    private final File CALORIES_FILE = new File("Calories.txt");
    private final File DAY_TRACKER_FILE = new File("daytracker.txt");   
    
    public CalorieTracker() {
        this.reader = new Reader();
        this.numDays = 0;
    }
    
    public void start() {
        welcomeMessage();
        while(true) {
            System.out.println("");
            System.out.println("What would you like to do?");
            String answer = reader.readString();
            
            if(answer.equalsIgnoreCase("quit")) {
                System.out.println("Thanks and good luck!");
                break;
            }
            if (answer.equalsIgnoreCase("add meal")) {
                addMeal();
            }
            if (answer.equalsIgnoreCase("show day total")) {
                System.out.println(readAndSumFile(DAY_TRACKER_FILE));
            }
            if (answer.equalsIgnoreCase("show total calories")) {
                System.out.println(readAndSumFile(CALORIES_FILE));
            }
            if (answer.equalsIgnoreCase("add day to total calories")) {
                addToTotalCalories();
            }
            if (answer.equalsIgnoreCase("show average day")) {
                System.out.println(readAndAverageCalories());
            }
            
        }
    }      
    
    private int readAndSumFile(File file) {
        int sum = 0;

        try {
            if (!file.exists() && file == DAY_TRACKER_FILE) {
                System.out.println("You need to add a meal first!");
                return 0;
            }
            if (!file.exists() && file == CALORIES_FILE) {
                System.out.println("You need to add your day to total calories "
                        + "first!");
                return 0;
            }
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            numDays = 0;
            try {
                while((line = br.readLine()) != null) { 
                    int lastInt = Integer.parseInt(line);
                    sum += lastInt;
                    numDays++;
                }
            }
            finally {
                br.close();
            }

        } catch (FileNotFoundException e) { 
            System.out.println("File not found! " + e);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException " + e);
        } catch (IOException e) {
            System.out.println("IOException! " + e);
        }

        return sum;
    }
    
    private void deleteTempFile(File file) {       
        if (file.delete()) {
            System.out.println(file.toString() + " deleted successfully!");
        } else {
            System.out.println(file.toString() + " failed to delete!");
        }
        
    }
    
    private void welcomeMessage() {
        System.out.println("Welcome to calorie tracker!");
        System.out.println("Commands are:");
        
        System.out.println("'show day total' - displays total calories "
                + "for the day");
        System.out.println("'show average day' - shows your average "
                + "daily caloric intake");
        System.out.println("'show total calories' - displays total "
                + "calories consumed");
        System.out.println("'add meal' - adds one meal to daytracker.txt");
        System.out.println("'add day to total calories' - adds calories "
                + "eaten today to your total calories file");
        
        System.out.println("You can quit by typing 'quit'");
    }
    
    private void addMeal() {
        System.out.print("How many calories would you like to add? ");
        int calories = reader.readInteger();
        System.out.print("Are you sure " + calories 
                + " is the correct amount? y/n: ");
        String answer = reader.readString();
        if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
            FileAssistant.writeToFile(DAY_TRACKER_FILE, calories);
        }
    }
    
    private void addToTotalCalories() {
        int totCalories = readAndSumFile(DAY_TRACKER_FILE);
        System.out.println("(NOTE: ADDING THESE CALORIES TO YOUR TRACKER WILL "
                + "DELETE YOUR DAILY TRACKING AMOUNT!");
        System.out.println("You have " + totCalories + " today.");
        System.out.println("Are you done eating for the day and want "
                + "to add this total to your tracking file? y/n: ");
        
        String answer = reader.readString();
        
        if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
            FileAssistant.writeToFile(CALORIES_FILE, totCalories);
            deleteTempFile(DAY_TRACKER_FILE);
        }
    }

    private int readAndAverageCalories() {
        int sum = readAndSumFile(CALORIES_FILE);
        if (numDays == 0) {
            return 0;
        }
        
        return sum / numDays;
    }
}
