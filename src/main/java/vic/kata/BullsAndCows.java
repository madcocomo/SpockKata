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
        List<Character> guessChars = new ArrayList<>();
        for (int i = 0; i < guess.length(); i++ ) {
            Character c = secret.charAt(i);
            if (c == guess.charAt(i)) {
                bulls += 1;
            } else {
                int count = secretCharCounts.getOrDefault(c,0);
                secretCharCounts.put(c, count+1);
                guessChars.add(guess.charAt(i));
            }
        }

        for (Map.Entry<Character, Integer> entry: secretCharCounts.entrySet()) {
            Character c = entry.getKey();
            for (int i = 0; i < entry.getValue(); i++) {
                if (guessChars.contains(c)) {
                    cows += 1;
                    guessChars.remove(c);
                }
            }
        }
        return bulls +"A" + cows + "B";
    }
}
