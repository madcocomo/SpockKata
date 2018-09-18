package vic.kata;

public class FirstMissingPositive {
    public static int of(int[] numbers) {
        for (int i = 0; i < numbers.length;) {
            int p = numbers[i];
            if (p <= 0 || p >= numbers.length || numbers[p - 1] == p) {
                i++;
            } else {
                numbers[i] = numbers[p - 1];
                numbers[p - 1] = p;
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != i+1) {
                return i+1;
            }
        }
        return numbers.length + 1;
    }
}
