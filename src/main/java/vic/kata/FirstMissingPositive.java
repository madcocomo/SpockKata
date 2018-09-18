package vic.kata;

public class FirstMissingPositive {
    public static int of(int[] numbers) {
        int missing = 1;
        int min = 100;
        int nextMissing = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > missing) {
                min = Math.min(numbers[i], min);
                nextMissing = Math.max(nextMissing, min+1);
                if (numbers[i] == nextMissing) {
                    nextMissing += 1;
                }
            }
            if (missing == numbers[i]) {
                missing += 1;
                if (missing == min) {
                    missing = nextMissing;
                }
            }
        }
        return missing;
    }
}
