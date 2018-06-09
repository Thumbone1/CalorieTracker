

package calorietracker.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thumbone1
 */
public class FileAssistant {
    public static final File CALORIES_FILE = new File("Calories.txt");
    public static final File DAY_TRACKER_FILE = new File("daytracker.txt");

    public static void writeToFile(File file, int total) {
        PrintWriter pw = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            
            pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            pw.println(total);
            
        } catch(IOException e) {
            System.out.println("IOException! " + e);
        } finally {
            pw.close();
            pw.flush();
        }
        
    }
    
    /**
     * 
     * @param file
     * @return empty list if file does not exist / list of ints if file exists
     * 
     * Throws NumberFormatException and IOException
     */
    public static List<Integer> initializeList(File file) {
        List<Integer> newList = new ArrayList<>();
        
        if (!file.exists()) {
            return newList;
        }
        
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            
            try {
                while((line = br.readLine()) != null) { 
                    newList.add(Integer.parseInt(line));
                }
            }
            finally {
                br.close();
            }
        } catch (NumberFormatException | IOException e) {
            System.out.println("Exception occured!\n " + e);
        }
        
        return newList;
    }
    
    public static boolean deleteFile(File file) {
        
        return file.delete();
        
    }
    
    public static void writeListToFile(File file, List<Integer> list) {
        if (list.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        
        for (int i : list) {
            writeToFile(file, i);
        }
    }

}
