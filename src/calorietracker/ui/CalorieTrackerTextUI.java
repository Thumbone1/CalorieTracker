
package calorietracker.ui;

import calorietracker.domain.CalorieCalculator;
import calorietracker.util.FileAssistant;
import calorietracker.util.TextReader;
import java.util.List;

/**
 *
 * @author Thumbone1
 */
public class CalorieTrackerTextUI {
    private TextReader reader;
    private CalorieCalculator tracker;
    
    public CalorieTrackerTextUI() {
        this.reader = new TextReader();
        this.tracker = new CalorieCalculator();
    }
    
    public void start() {
        welcomeMessage();
        while(true) {
            addSpacer();
            System.out.print("What would you like to do? ");
            
            int answer = reader.readInteger();
            
            switch (answer) {
                case 1: 
                    showDaySoFar();
                    break;
                case 2: 
                    showAverageDay();
                    break;
                case 3:
                    showMaxDay();
                    break;
                case 4: 
                    addMeal();
                    break;
                case 5:
                    addDayToTotal();
                    break;
                case 6: 
                    editDayTracker();
                    break;
                case 0:
                    exit();
                    break;
            }
            
        }
    }
    
    private void welcomeMessage() {
        System.out.println(
                "1 - display all of your meals and your total calories for the day\n" +
                "2 - display your average daily caloric intake\n" +
                "3 - display highest calories consumed in a day\n" +
                "4 - add one meal to your day tracker\n" +
                "5 - add calories eaten today to your total calories\n" +
                "6 - edit/delete your day tracker (submenu)\n" + //methods for this need to be implemented in FileAssistant
                "0 - quit program"
        );        
        
    }

    private void showDaySoFar() {
        if (tracker.totalDayCalories() < 0) {
            System.out.println("\tYou have not added any meals yet");
            return;
        }
        
        // file should be short so this doesn't take many resources
        List<Integer> day = FileAssistant.initializeList(
                FileAssistant.DAY_TRACKER_FILE);
        
        for (int i : day) {
            System.out.println("\t" + i);
        }
        
        System.out.println("\tTotal calories for the day: " + 
                tracker.totalDayCalories());
        
    }

    private void showAverageDay() {
        int avg = tracker.average();
        
        if (avg < 0) {
            
            System.out.println("\tYou have not added a day total to "
                    + "total calories yet.");
            return;
        }
        
        System.out.println("\tAverage calories per day: " + avg);
        
    }

    private void showMaxDay() {
        int max = tracker.maxCalories();
        
        if (max < 0) {
            System.out.println("\tYou have not added a day total to "
                    + "total calories yet.");
            return;
        }
        
        System.out.println("\tHighest calries consumed in a day: " + max);
    }

    private void addMeal() {
        System.out.print("How many calories would you like to add? ");
        int cal = reader.readInteger();
        
        System.out.print("Are you sure you want to add " + cal + 
                " calories to your meal tracker? y/n: ");
        String ans = reader.readString().toLowerCase().trim();
        if (ans.contains("y")) {
            FileAssistant.writeToFile(FileAssistant.DAY_TRACKER_FILE, cal);
            tracker.reInitializeDayTracker();
        }
        
    }

    private void addDayToTotal() {
        System.out.print("NOTE THAT DOING THIS WILL DELETE YOUR MEAL TRACKER!\n"
                + " Are you sure you are done eating for the day? y/n: ");
        String ans = reader.readString().toLowerCase().trim();
        
        if (ans.contains("y")) {
            int dayTotal = tracker.totalDayCalories();
            FileAssistant.writeToFile(FileAssistant.CALORIES_FILE, dayTotal);
            if (FileAssistant.deleteFile(FileAssistant.DAY_TRACKER_FILE)) {
                System.out.println("meal tracker deleted and "
                        + "total calories updated!");
                tracker.reInitializeCalories();
                tracker.reInitializeDayTracker();
            } else {
                System.out.println("Something went wrong!");
                                 
            }
        }
    }
    
    private void editDayTracker() {
        System.out.println("OPTIONS: \n"
                + "1 - edit meal tracker\n"
                + "2 - delete meal tracker");
        
    }

    private void exit() {
        System.out.println("\tExiting Program");
        tracker = null;
        reader = null;
        System.exit(0);
    }
    
    private void addSpacer() {
        System.out.println("\n");
    }

    

}
