

import java.util.*;
import java.util.stream.*;

class Bogie {
    String name;
    String type;
    public Bogie(String name, String type) {
        this.name = name;
        this.type = type;
    }
}

public class TrainApp {
    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                     .collect(Collectors.groupingBy(b -> b.type));
    }

    public static void main(String[] args) {
        System.out.println("=== UC9: Group Bogies Using Streams ===");
        List<Bogie> list = Arrays.asList(
            new Bogie("S1", "Sleeper"),
            new Bogie("S2", "Sleeper"),
            new Bogie("AC1", "AC Chair")
        );
        Map<String, List<Bogie>> grouped = groupBogiesByType(list);
        System.out.println("Groups keys: " + grouped.keySet());
    }
}
