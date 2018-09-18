package vic.kata;

public class FirstMissingPositive {
    public static int of(int[] numbers) {
        int missing = 1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > missing) {
                min = numbers[i];
            }
            if (numbers[i] == missing) {
                missing = numbers[i] + 1;
                if (missing == min) {
                    missing = min + 1;
                }
            }
        }
        return missing;
    }
}
