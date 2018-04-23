package vic.kata;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MaximumNumberFrom2Arrays {
    public int[] maxNumberOf(int[] num1, int[] num2, int k) {
        Set<IndexState> candidates = new HashSet<>();
        candidates.add(new IndexState(0,0));
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            Set<IndexState> nextCandidates = new HashSet<>();
            for (IndexState state : candidates) {
                int maxP1 = getMaxIndex(num1, state.p1, getLimit(k, i, num1.length, num2.length - state.p2));
                int max1 = valueOrMinimize(num1, maxP1);
                if (result[i] < max1) {
                    nextCandidates.clear();
                }
                if (result[i] <= max1) {
                    result[i] = max1;
                    nextCandidates.add(new IndexState(maxP1 + 1, state.p2));
                }

                int maxP2 = getMaxIndex(num2, state.p2, getLimit(k, i, num2.length, num1.length - state.p1));
                int max2 = valueOrMinimize(num2, maxP2);
                if (result[i] < max2) {
                    nextCandidates.clear();
                }
                if (result[i] <= max2) {
                    result[i] = max2;
                    nextCandidates.add(new IndexState(state.p1, maxP2 + 1));
                }

                candidates = nextCandidates;
            }
        }

        return result;
    }

    private int getLimit(int k, int resultIndex, int length, int anotherLength) {
        return Math.min(length, length + anotherLength - (k - resultIndex) + 1);
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

    class IndexState {
        final int p1, p2;
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IndexState state = (IndexState) o;
            return p1 == state.p1 &&
                    p2 == state.p2;
        }
        @Override
        public int hashCode() {
            return Objects.hash(p1, p2);
        }
        IndexState(int p1, int p2) {
            this.p1 = p1;
            this.p2 = p2;
        }
    }
}
