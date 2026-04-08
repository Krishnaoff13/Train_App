package UC7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Bogie {
    String name;
    int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + " seats)";
    }
}

public class TrainApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        List<Bogie> passengerBogies = new ArrayList<>();
        
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 60));
        passengerBogies.add(new Bogie("First Class", 24));
        
        passengerBogies.sort(Comparator.comparingInt(b -> b.capacity));
        
        System.out.println("Sorted bogies based on capacity:");
        for (Bogie b : passengerBogies) {
            System.out.println(b);
        }
    }
}
