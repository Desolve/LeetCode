// 因限定0~1000，使用一個紀錄次數再分配到新的array，可以達成分別的ascending sort.
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int[] table = new int[1001];
        int[] res = new int[A.length];
        for (int num: A) ++table[num];
        for (int i = 0, p = 0; i < A.length; i += 2) {
            while (table[p] == 0) p += 2;
            res[i] = p;
            --table[p];
        }
        for (int i = 1, p = 1; i < A.length; i += 2) {
            while (table[p] == 0) p += 2;
            res[i] = p;
            --table[p];
        }
        return res;
    }
}

/* Faster solution: Find a wrong-placed odd, and swap with the wrong-placed even one by one.
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        for (int i = 0, j = 1; i < A.length; i += 2) {
            while (j < A.length && A[j] % 2 == 1) j += 2;
            if (A[i] % 2 == 1) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
                j += 2;
            }
        }
        return A;
    }
}
*/