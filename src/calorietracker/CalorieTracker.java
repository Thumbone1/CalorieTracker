package calorietracker;

import calorietracker.util.FileAssistant;
import calorietracker.util.Reader;
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
    
    private int numDays;
    private final File CALORIES_FILE = new File("Calories.txt");
    private final File DAY_TRACKER_FILE = new File("daytracker.txt");   
    
    public CalorieTracker() {
        this.numDays = 0;
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
