package calorietracker.domain;

import calorietracker.util.FileAssistant;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Thumbone1
 */
public class CalorieCalculator {
    
    private List<Integer> calories;
    private List<Integer> dayCalories;
    
    public CalorieCalculator() {
        this.calories = FileAssistant.initializeList(FileAssistant.CALORIES_FILE);
        this.dayCalories = FileAssistant.initializeList(FileAssistant.DAY_TRACKER_FILE);
        
    }
    
    public int average() {
        if (calories.isEmpty()) {
            return -1;
        }
        
        return sum(calories) / calories.size();
    }
    
    public int totalCalories() {
        if (calories.isEmpty()) {
            return -1;
        }
        
        return sum(calories);
    }
    
    public int totalDayCalories() {
        if (dayCalories.isEmpty()) {
            return -1;
        }
        
        return sum(dayCalories);
    }
    
    public int maxCalories() {
        if (calories.isEmpty()) {
            return -1;
        }
        
        return Collections.max(calories);
    }
    
    public int minCalories() {
        if (calories.isEmpty()) {
            return -1;
        }
        
        return Collections.min(calories);
    }
    
    public void reInitializeDayTracker() {
        this.dayCalories = FileAssistant.initializeList(FileAssistant.DAY_TRACKER_FILE);
    }
    
    public void reInitializeCalories() {
        this.calories = FileAssistant.initializeList(FileAssistant.CALORIES_FILE);
    }
    
    private int sum(List<Integer> list) {
        int total = 0;
        
        for (int i : list) {
            total += i;
        }
        
        return total;
    }
    
    
}
