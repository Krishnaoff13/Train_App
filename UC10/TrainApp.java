package UC10;

import java.util.*;

class Bogie {
    String name;
    int capacity;
    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}

public class TrainApp {
    public static int countTotalSeats(List<Bogie> bogies) {
        return bogies.stream()
                     .map(b -> b.capacity)
                     .reduce(0, Integer::sum);
    }
    public static void main(String[] args) {}
}
