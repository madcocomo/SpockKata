package vic.kata;

public class MaximumNumberFrom2Arrays {
    public int[] maxNumberOf(int[] num1, int[] num2, int k) {
        int[] result = new int[k];
        int max = -1;
        for (int i = 0; i < num1.length; i++) {
           if (max < num1[i]) {
               max = num1[i];
           }
        }
        result[0] = max;
        return result;
    }
}
