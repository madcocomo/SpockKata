package vic.kata;

public class BullsAndCows {
    public static String getHint(String secret, String guess) {
        int bulls = 0;
        if (secret.charAt(0) == guess.charAt(0)) {
            bulls = 1;
        }
        return bulls +"A0B";
    }
}
