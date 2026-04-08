package UC3;

import java.util.HashSet;
import java.util.Set;

public class TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        Set<String> passengerBogies = new HashSet<>();
        
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");
        passengerBogies.add("Sleeper"); // Duplicate ignored
        
        System.out.println("Unique IDs displayed: " + passengerBogies);
    }
}
