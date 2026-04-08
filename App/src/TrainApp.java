

import java.util.HashMap;
import java.util.Map;

public class TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        Map<String, Integer> bogieCapacity = new HashMap<>();
        
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 60);
        bogieCapacity.put("First Class", 24);
        
        System.out.println("Capacity details for each bogie:");
        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " seats/load");
        }
    }
}
