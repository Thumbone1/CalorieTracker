package calorietracker.domain;

import calorietracker.util.FileAssistant;
import java.io.File;
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
        
        return total(calories) / calories.size();
    }
    
    public int total(List<Integer> list) {
        if (list.isEmpty()) {
            return -1;
        }
        
        int total = 0;
        
        for (int i : calories) {
            total += i;
        }
        
        return total;
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
    
    
}
