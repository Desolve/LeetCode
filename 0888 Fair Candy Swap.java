class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int diff = 0;
        int[] res = new int[2];
        for (int size : A) diff += size;
        for (int size : B) diff -= size;
        diff /= 2;
        if (diff > 0) {
            for (int i = 0, j = 0; ; ) {
                int swap = A[i] - B[j];
                if (swap < diff) ++i;
                else if (swap > diff) ++j;
                else {
                    res[0] = A[i];
                    res[1] = B[j];
                    return res;
                }
            }
        } else {
            diff = -diff;
            for (int i = 0, j = 0; ;) {
                int swap = B[j] - A[i];
                if (swap < diff) ++j;
                else if (swap > diff) ++i;
                else {
                    res[0] = A[i];
                    res[1] = B[j];
                    return res;
                }               
            }
        }
    }
}

/* Faster solution using HashSet
class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        Set<Integer> set = new HashSet<>();
        int diff = 0;
        for (int size : A) {
            diff += size;
            set.add(size);
        }
        for (int size : B) diff -= size;
        diff /= 2;
        for (int res : B) {
            if (set.contains(res + diff))
                return new int[]{res + diff, res};
        }
        return new int[2];
    }
}
*/