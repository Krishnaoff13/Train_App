

import java.util.*;
import java.util.stream.*;

class Bogie {
    String name;
    int capacity;
    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}

public class TrainApp {
    public static List<Bogie> filterBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                     .filter(b -> b.capacity > threshold)
                     .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("=== UC8: Filter Passenger Bogies ===");
        List<Bogie> list = Arrays.asList(
            new Bogie("Sleeper", 72),
            new Bogie("AC Chair", 60),
            new Bogie("First Class", 24)
        );
        List<Bogie> filtered = filterBogies(list, 60);
        System.out.println("Filtered bogies (capacity > 60): " + filtered.size());
    }
}
