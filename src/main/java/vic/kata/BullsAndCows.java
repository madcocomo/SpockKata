package vic.kata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BullsAndCows {
    public static String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        Map<Character, Integer> secretCharCounts = new HashMap<>();
        Map<Character, Integer> guessCharCounts = new HashMap<>();
        for (int i = 0; i < guess.length(); i++ ) {
            Character c = secret.charAt(i);
            if (c == guess.charAt(i)) {
                bulls += 1;
            } else {
                int count = secretCharCounts.getOrDefault(c,0);
                secretCharCounts.put(c, count+1);

                Character c2 = guess.charAt(i);
                int count2 = guessCharCounts.getOrDefault(c2,0);
                guessCharCounts.put(c2, count2+1);
            }
        }

        for (Map.Entry<Character, Integer> entry: secretCharCounts.entrySet()) {
            Character c = entry.getKey();
            if (guessCharCounts.getOrDefault(c, 0) < entry.getValue()) {
                cows += guessCharCounts.getOrDefault(c,0);
            } else {
                cows += entry.getValue();
            }
        }
        return bulls +"A" + cows + "B";
    }
}
