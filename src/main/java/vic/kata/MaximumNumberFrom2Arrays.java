package vic.kata;

public class MaximumNumberFrom2Arrays {
    public int[] maxNumberOf(int[] num1, int[] num2, int k) {
        int[] result = new int[k];
        for (int i = 0, maxP1 = 0, maxP2 = 0; i < k; i++) {
            for (int p = maxP1; p < num1.length - num2.length - (k - i) + 1; p++) {
                if (num1[maxP1] < num1[p]) {
                    maxP1 = p;
                }
            }
            for (int p = maxP2; p < num2.length - num1.length - (k - i) + 1; p++) {
                if (num2[maxP2] < num2[p]) {
                    maxP2 = p;
                }
            }
            if (num1.length > maxP1) {
                result[i] = num1[maxP1];
                maxP1++;
            }
            if (num2.length > maxP2) {
                result[i] = num2[maxP2];
                maxP2++;
            }
        }

        return result;
    }
}
