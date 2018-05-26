package calorietracker;


import java.util.Scanner;

/**
 *
 * @author Thumbone1
 */
public class Reader {
    private Scanner sc = new Scanner(System.in);
    
    public String readString() {
        return sc.nextLine();
    }
    
    public int readInteger() {
        return Integer.parseInt(sc.nextLine());
    }
}
