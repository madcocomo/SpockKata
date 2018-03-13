package vic.kata;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {
    public static String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        Map<Character, Integer> secretCharCounts = new HashMap<>();
        Map<Character, Integer> guessCharCounts = new HashMap<>();
        for (int i = 0; i < guess.length(); i++ ) {
            Character secretC = secret.charAt(i);
            Character guessC = guess.charAt(i);
            if (secretC == guess.charAt(i)) {
                bulls += 1;
            } else {
                secretCharCounts.put(secretC, secretCharCounts.getOrDefault(secretC,0) +1);
                guessCharCounts.put(guessC, guessCharCounts.getOrDefault(guessC,0) +1);
            }
        }

        for (Character c : secretCharCounts.keySet()) {
            Integer secretCount = secretCharCounts.get(c);
            Integer guessCount = guessCharCounts.getOrDefault(c, 0);
            cows += Math.min(secretCount, guessCount);
        }
        return bulls +"A" + cows + "B";
    }
}
