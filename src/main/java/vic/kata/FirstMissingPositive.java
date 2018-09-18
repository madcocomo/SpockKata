package vic.kata;

public class FirstMissingPositive {
    public static int of(int[] numbers) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            int p = numbers[i];
            if (p <= 0 || p > numbers.length) {
                numbers[i] = 0;
            } else {
                count++;
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            int p = numbers[i];
            while (p > 0) {
                numbers[i] = numbers[p - 1] > 0 ? numbers[p - 1] : 0;
                numbers[p - 1] = -p;
                p = numbers[i];
            }
        }
        for (int i = 0; i < count; i++) {
            if (numbers[i] == 0) {
                return i+1;
            }
        }
        return count + 1;
    }
}
