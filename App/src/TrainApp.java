

import java.util.ArrayList;
import java.util.List;

public class TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        List<String> passengerBogies = new ArrayList<>();
        
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");
        
        System.out.println("List after insertion: " + passengerBogies);
        
        passengerBogies.remove("AC Chair");
        
        boolean hasSleeper = passengerBogies.contains("Sleeper");
        System.out.println("Contains Sleeper? " + hasSleeper);
        
        System.out.println("Final list state: " + passengerBogies);
    }
}
