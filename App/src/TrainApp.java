

import java.util.regex.*;

public class TrainApp {
    private static final Pattern TRAIN_ID_PATTERN = Pattern.compile("TRN-\\d{4}");
    private static final Pattern CARGO_CODE_PATTERN = Pattern.compile("PET-[A-Z]{2}");

    public static boolean validateTrainId(String input) {
        if (input == null) return false;
        return TRAIN_ID_PATTERN.matcher(input).matches();
    }

    public static boolean validateCargoCode(String input) {
        if (input == null) return false;
        return CARGO_CODE_PATTERN.matcher(input).matches();
    }
    public static void main(String[] args) {}
}
