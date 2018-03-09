package vic.kata;

public class BullsAndCows {
    public static String getHint(String secret, String guess) {
        int bulls = 0;
        if (secret.equals(guess)) {
            bulls = 1;
        }
        return bulls +"A0B";
    }
}
