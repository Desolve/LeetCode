class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int l = Math.max(A[i][0], B[j][0]);
            int r = Math.min(A[i][1], B[j][1]);
            if (l <= r) res.add(new int[]{l, r});
            if (A[i][1] < B[j][1])
                i++;
            else
                j++;
        }
        return res.toArray(new int[res.size()][]);
    }
}