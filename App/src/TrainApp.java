

import java.util.*;

class Bogie {
    String type;
    String cargo;
    public Bogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }
}

public class TrainApp {
    public static boolean isTrainSafe(List<Bogie> bogies) {
        return bogies.stream().allMatch(b -> {
            if ("Cylindrical".equalsIgnoreCase(b.type)) {
                return "Petroleum".equalsIgnoreCase(b.cargo);
            }
            return true;
        });
    }
    public static void main(String[] args) {}
}
