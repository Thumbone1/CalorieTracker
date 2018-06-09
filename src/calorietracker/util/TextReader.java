package calorietracker.util;


import java.util.Scanner;

/**
 *
 * @author Thumbone1
 */
public class TextReader {
    private Scanner sc = new Scanner(System.in);
    
    public String readString() {
        return sc.nextLine();
    }
    
    public int readInteger() {
        return Integer.parseInt(sc.nextLine());
    }
}
