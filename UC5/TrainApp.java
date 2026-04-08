package UC5;

import java.util.LinkedHashSet;
import java.util.Set;

public class TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        Set<String> formation = new LinkedHashSet<>();
        
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        
        formation.add("Sleeper"); // Intentional duplicate
        
        System.out.println("Final formation order: " + formation);
    }
}
