package vic.kata;

public class MaximumNumberFrom2Arrays {
    public int[] maxNumberOf(int[] num1, int[] num2, int k) {
        int[] result = new int[k];
        int maxI = -1;
        for (int i = 0; i < num1.length - k + 1; i++) {
           if (maxI == -1 || num1[maxI] < num1[i]) {
               maxI = i;
           }
        }
        for (int i = 0; i < k; i++) {
            result[i] = num1[maxI+i];
        }

        return result;
    }
}
