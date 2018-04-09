package vic.kata;

public class MaximumNumberFrom2Arrays {
    public int[] maxNumberOf(int[] num1, int[] num2, int k) {
        int[] result = new int[k];
        for (int i = 0, maxP = 0; i < k; i++, maxP++) {
            for (int p = maxP; p < num1.length - (k - i) + 1; p++) {
                if (num1[maxP] < num1[p]) {
                    maxP = p;
                }
            }
            result[i] = num1[maxP];
        }

        return result;
    }
}
