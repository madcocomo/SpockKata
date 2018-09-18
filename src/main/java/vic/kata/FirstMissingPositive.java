package vic.kata;

public class FirstMissingPositive {
    public static int of(int[] numbers) {
        int missing = 1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == missing) {
                missing = numbers[i] + 1;
            }
        }
        return missing;
    }
}
