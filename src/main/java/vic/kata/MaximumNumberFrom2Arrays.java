package vic.kata;

public class MaximumNumberFrom2Arrays {
    public int[] maxNumberOf(int[] num1, int[] num2, int k) {
        int[] result = new int[k];
        for (int i = 0, maxP1 = 0, maxP2 = 0; i < k; i++) {
            maxP1 = getMaxIndex(num1, maxP1, getLimit(k, i, num1.length, num2.length));
            maxP2 = getMaxIndex(num2, maxP2, getLimit(k, i, num2.length, num1.length));
            int max1 = valueOrMinimize(num1, maxP1);
            int max2 = valueOrMinimize(num2, maxP2);
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

    private int getMaxIndex(int[] num, int start, int limit) {
        int maxIndex = start;
        for (int p = start; p < limit; p++) {
            if (valueOrMinimize(num, maxIndex) < num[p]) {
                maxIndex = p;
            }
        }
        return maxIndex;
    }

    private int getLimit(int k, int resultIndex, int length, int anotherLength) {
        return Math.min(length, length + anotherLength - (k - resultIndex) + 1);
    }

    private int valueOrMinimize(int[] num, int index) {
        return index < num.length ? num[index] : -1;
    }
}
