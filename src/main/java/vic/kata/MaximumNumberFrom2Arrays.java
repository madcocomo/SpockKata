package vic.kata;

public class MaximumNumberFrom2Arrays {
    public int[] maxNumberOf(int[] num1, int[] num2, int k) {
        int[] result = new int[k];
        for (int i = 0, maxP1 = 0, maxP2 = 0; i < k; i++) {
            int max1 = -1, max2 = -1;
            for (int p = maxP1;
                 p < Math.min(num1.length, num1.length + num2.length - (k - i) + 1);
                 p++) {
                if (max1 < num1[p]) {
                    maxP1 = p;
                    max1 = num1[p];
                }
            }
            for (int p = maxP2;
                 p < Math.min(num2.length, num2.length + num1.length - (k - i) + 1);
                 p++) {
                if (max2 < num2[p]) {
                    maxP2 = p;
                    max2 = num2[p];
                }
            }
            if (max1 > max2) {
                result[i] = max1;
                maxP1++;
            } else {
                result[i] = max2;
                maxP2++;
            }
        }

        return result;
    }
}
