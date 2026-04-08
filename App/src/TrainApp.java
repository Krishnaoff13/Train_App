

import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

public class TrainApp {
    private static final Pattern TRAIN_ID_PATTERN = Pattern.compile("TRN-\\d{4}");
    private static final Pattern CARGO_CODE_PATTERN = Pattern.compile("PET-[A-Z]{2}");

    public static List<Bogie> filterBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                     .filter(b -> b.getCapacity() > threshold)
                     .collect(Collectors.toList());
    }

    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                     .collect(Collectors.groupingBy(Bogie::getType));
    }

    public static int countTotalSeats(List<Bogie> bogies) {
        return bogies.stream()
                     .map(Bogie::getCapacity)
                     .reduce(0, Integer::sum);
    }

    public static boolean validateTrainId(String input) {
        if (input == null) return false;
        return TRAIN_ID_PATTERN.matcher(input).matches();
    }

    public static boolean validateCargoCode(String input) {
        if (input == null) return false;
        return CARGO_CODE_PATTERN.matcher(input).matches();
    }

    public static boolean isTrainSafe(List<Bogie> bogies) {
        return bogies.stream().allMatch(b -> {
            if ("Cylindrical".equalsIgnoreCase(b.getType())) {
                return "Petroleum".equalsIgnoreCase(b.getCargo());
            }
            return true;
        });
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App (Combined with UC8-UC12) ===");
        
        List<Bogie> allBogies = Arrays.asList(
            new Bogie("Sleeper", 72),
            new Bogie("AC Chair", 60),
            new Bogie("First Class", 24),
            new Bogie("Cylindrical", "Petroleum"),
            new Bogie("Open", "Coal")
        );

        System.out.println("\nUC8: Filter Passenger Bogies (> 50 capacity)");
        filterBogies(allBogies, 50).forEach(System.out::println);

        System.out.println("\nUC9: Group Bogies by Type");
        groupBogiesByType(allBogies).forEach((k, v) -> System.out.println(k + " -> " + v.size() + " bogies"));

        System.out.println("\nUC10: Total Seats");
        System.out.println("Total Seats: " + countTotalSeats(allBogies));

        System.out.println("\nUC11: Validate Train ID");
        System.out.println("TRN-1234 -> " + validateTrainId("TRN-1234"));

        System.out.println("\nUC12: Safety Compliance");
        System.out.println("Is safe? -> " + isTrainSafe(allBogies));
    }
}
