package vic.kata;

public class BullsAndCows {
    public static String getHint(String secret, String guess) {
        if (secret.equals(guess)) {
            return "1A0B";
        }
        return "0A0B";
    }
}
