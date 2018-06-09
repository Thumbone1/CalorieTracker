

package calorietracker.ui;

import calorietracker.CalorieTracker;
import calorietracker.util.Reader;

/**
 *
 * @author Thumbone1
 */
public class CalorieTrackerTextUI {
    private Reader reader;
    private CalorieTracker tracker;
    
    public CalorieTrackerTextUI() {
        this.reader = new Reader();
        this.tracker = new CalorieTracker();
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

}
