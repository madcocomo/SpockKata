package vic.kata;

public class BullsAndCows {
    public static String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] secretDigitCounts = new int[10];
        int[] guessDigitCounts = new int[10];
        for (int i = 0; i < guess.length(); i++ ) {
            int secretDigit = secret.charAt(i) - '0';
            int guessDigit = guess.charAt(i) - '0';
            if (secretDigit == guessDigit) {
                bulls += 1;
            } else {
                secretDigitCounts[secretDigit] += 1;
                guessDigitCounts[guessDigit] += 1;
            }
        }

        for (int i = 0; i < 10; i++) {
            Integer secretCount = secretDigitCounts[i];
            Integer guessCount = guessDigitCounts[i];
            cows += Math.min(secretCount, guessCount);
        }
        return bulls +"A" + cows + "B";
    }
}
