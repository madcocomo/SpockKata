package vic.kata;

public class FirstMissingPositive {
    public static int of(int[] numbers) {
        int missing = 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > missing) {
                min = Math.min(numbers[i], min);
                max = Math.max(numbers[i], max);
            }
            if (missing == numbers[i]) {
                missing += 1;
                if (missing == min) {
                    missing += 1;
                    if (missing == max) {
                        missing += 1;
                    }

                }
            }
        }
        return missing;
    }
}
