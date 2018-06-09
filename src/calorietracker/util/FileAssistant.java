

package calorietracker.util;

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

    public static void writeToFile(File file, int total) {
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
    
    public static void deleteTempFile(File file) {       
        if (file.delete()) {
            System.out.println(file.toString() + " deleted successfully!");
        } else {
            System.out.println(file.toString() + " failed to delete!");
        }
        
    }
    

}
