package vic.kata;

public class BullsAndCows {
    public static String getHint(String secret, String guess) {
        int bulls = 0;
        for (int i = 0; i < secret.length(); i++ ) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls = 1;
            }
        }
        return bulls +"A0B";
    }
}
