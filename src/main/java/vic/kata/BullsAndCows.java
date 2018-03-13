package vic.kata;

import java.util.ArrayList;
import java.util.List;

public class BullsAndCows {
    public static String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        List<Character> secretChars = new ArrayList<>();
        List<Character> guessChars = new ArrayList<>();
        for (int i = 0; i < guess.length(); i++ ) {
            Character c = secret.charAt(i);
            if (c == guess.charAt(i)) {
                bulls += 1;
            } else {
                secretChars.add(c);
                guessChars.add(guess.charAt(i));
            }
        }

        for (Character c : secretChars) {
            if (guessChars.contains(c)) {
                cows += 1;
                guessChars.remove(c);
            }
        }
        return bulls +"A" + cows + "B";
    }
}
