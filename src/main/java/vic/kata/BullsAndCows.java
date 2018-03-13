package vic.kata;

public class BullsAndCows {
    public static String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] secretDigitCounts = new int[10];
        int[] guessDigitCounts = new int[10];
        for (int i = 0; i < guess.length(); i++ ) {
            int secretDigit = toDigit(secret.charAt(i));
            int guessDigit = toDigit(guess.charAt(i));
            if (secretDigit == guessDigit) {
                bulls += 1;
            } else {
                secretDigitCounts[secretDigit] += 1;
                guessDigitCounts[guessDigit] += 1;
            }
        }

        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretDigitCounts[i], guessDigitCounts[i]);
        }
        return bulls +"A" + cows + "B";
    }

    private static int toDigit(char c) {
        return c - '0';
    }
}
