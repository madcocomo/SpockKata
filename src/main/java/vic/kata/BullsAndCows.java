package vic.kata;

import java.util.ArrayList;
import java.util.List;

public class BullsAndCows {
    public static String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        List<Character> guessChar = new ArrayList<>();
        for (int i = 0; i < guess.length(); i++ ) {
            guessChar.add(guess.charAt(i));
        }

        for (int i = 0; i < secret.length(); i++ ) {
            Character c = secret.charAt(i);
            if (c == guess.charAt(i)) {
                bulls += 1;
            } else if (guessChar.contains(c)) {
                cows += 1;
                guessChar.remove(c);
            }
        }
        return bulls +"A" + cows + "B";
    }
}
