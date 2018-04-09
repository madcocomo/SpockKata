package vic.kata;

public class MaximumNumberFrom2Arrays {
    public int[] maxNumberOf(int[] num1, int[] num2, int k) {
        int[] result = new int[k];
        for (int i = 0, maxP1 = 0, maxP2 = 0; i < k; i++) {
            int oldMaxP1 = maxP1;
            int oldMaxP2 = maxP2;
            maxP1 = getMaxIndex(num1, maxP1, getLimit(k, i, num1.length, num2.length-oldMaxP2));
            maxP2 = getMaxIndex(num2, maxP2, getLimit(k, i, num2.length, num1.length-oldMaxP1));
            int max1 = valueOrMinimize(num1, maxP1);
            int max2 = valueOrMinimize(num2, maxP2);
            boolean select1 = false;
            if (max1 == max2) {
                select1 = num1[0] < num2[0];
            }
            if (select1 || max1 > max2) {
                result[i] = max1;
                maxP1++;
                maxP2 = oldMaxP2;
            } else {
                result[i] = max2;
                maxP2++;
                maxP1 = oldMaxP1;
            }
        }

        return result;
    }

    private int getLimit(int k, int resultIndex, int length, int anotherLength) {
        int result = Math.min(length, length + anotherLength - (k - resultIndex) + 1);
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

    private int valueOrMinimize(int[] num, int index) {
        return index < num.length ? num[index] : -1;
    }
}
