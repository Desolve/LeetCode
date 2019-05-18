class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] res = new int[queries.length];
        int sum = 0;
        for (int num : A) {
            if (num % 2 == 0) 
                sum += num;
        }
        
        for (int i = 0; i < queries.length; i++) {
            int prev = A[queries[i][1]];
            int next = prev + queries[i][0];
            if (prev % 2 == 0) sum -= prev;
            if (next % 2 == 0) sum += next;
            A[queries[i][1]] = next;
            res[i] = sum;
        }
        return res;
    }
}