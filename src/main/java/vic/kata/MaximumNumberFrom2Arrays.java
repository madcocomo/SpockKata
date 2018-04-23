package vic.kata;

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberFrom2Arrays {
    class IndexState {
        int p1, p2;
        IndexState(int p1, int p2) {
            this.p1 = p1;
            this.p2 = p2;
        }
    }
    public int[] maxNumberOf(int[] num1, int[] num2, int k) {
        Set<IndexState> candidates = new HashSet<>();
        candidates.add(new IndexState(0,0));
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            IndexState state = candidates.iterator().next();
            int maxP1 = getMaxIndex(num1, state.p1, getLimit(k, i, num1.length, num2.length- state.p2));
            int maxP2 = getMaxIndex(num2, state.p2, getLimit(k, i, num2.length, num1.length- state.p1));
            int max1 = valueOrMinimize(num1, maxP1);
            int max2 = valueOrMinimize(num2, maxP2);
            int select1 = max1 - max2;
            if (select1 == 0) {
                for (int n = 1; n < Math.max(num1.length, num2.length); n++) {
                    int i1 = valueOrMinimize(num1, maxP1 + n);
                    int i2 = valueOrMinimize(num2, maxP2 + n);
                    if (i1 != i2) {
                        select1 = i1 - i2;
                        break;
                    }
                }
            }
            if (select1 == 0) {
                int maxBeforeP1 = getMaxNumberBefore(maxP1, num1, k, i);
                int maxBeforeP2 = getMaxNumberBefore(maxP2, num2, k, i);
                select1 = maxBeforeP2 - maxBeforeP1;
            }
            Set<IndexState> nextCandidates = new HashSet<>();
            if (select1 > 0) {
                result[i] = max1;
                nextCandidates.add(new IndexState(maxP1+1, state.p2));
            } else {
                result[i] = max2;
                nextCandidates.add(new IndexState(state.p1, maxP2+1));
            }
            candidates = nextCandidates;
        }

        return result;
    }

    private int getMaxNumberBefore(int maxP1, int[] num1, int k, int i) {
        int result = -1;
        for (int n = 0; n < Math.min(maxP1,num1.length-(k-i-1)+1); n++) {
            if (result < num1[n]) {
                result = num1[n];
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
