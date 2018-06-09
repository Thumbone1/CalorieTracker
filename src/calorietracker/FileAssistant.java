

package calorietracker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Thumbone1
 */
public class FileAssistant {
    private final File CALORIES_FILE = new File("Calories.txt");
    private final File DAY_TRACKER_FILE = new File("daytracker.txt");

    public void writeToFile(File file, int total) {
        PrintWriter pw = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            
            pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            pw.println(total);
            System.out.println(total + " added to " + file.toString());
            
        } catch(IOException e) {
            System.out.println("IOException " + e);
        
        } catch(Exception e) {
            System.out.println("IOException " + e);
        
        } finally {
            pw.close();
            pw.flush();
        }
        
    }
    
    public void deleteTempFile(File file) {       
        if (file.delete()) {
            System.out.println(file.toString() + " deleted successfully!");
        } else {
            System.out.println(file.toString() + " failed to delete!");
        }
        
    }
    

}
