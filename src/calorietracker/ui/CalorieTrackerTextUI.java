
package calorietracker.ui;

import calorietracker.domain.CalorieCalculator;
import calorietracker.util.TextReader;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Thumbone1
 */
public class CalorieTrackerTextUI {
    private TextReader reader;
    private CalorieCalculator tracker;
    private Map<String, String> options; 
    
    public CalorieTrackerTextUI() {
        this.reader = new TextReader();
        this.tracker = new CalorieCalculator();
        this.options = new TreeMap();
    }
    
    public void start() {
        welcomeMessage();
        while(true) {
            System.out.println("");
            System.out.println("What would you like to do?");
            int answer = reader.readInteger();
            
            if(answer == 0) {
                break;
            }
            if (answer == 1) {
                
            }
            if (answer == 2) {
                
            }
            if (answer == 3) {
                
            }
            if (answer == 4) {
                
            }
            if (answer == 5) {
                
            }
            
        }
    }
    
    private void welcomeMessage() {
        System.out.println(
                "1 - displays total calories for the day\n" +
                "2 - shows your average daily caloric intake\n" +
                "3 - displays total calories consumed\n" +
                "4 - adds one meal to daytracker.txt\n" +
                "5 - adds calories eaten today to your total calories file\n" +
                "0 - quit program"
        );        
        
    }

}
