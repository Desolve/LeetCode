class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] trust_other = new int[N];
        int[] be_trusted = new int[N];
        for (int[] pair: trust) {
            ++trust_other[pair[0]-1];
            ++be_trusted[pair[1]-1];
        }
        for (int i = 0; i < N; ++i) {
            if (trust_other[i] == 0 && be_trusted[i] == N-1)
                return i+1;
        }
        
        return -1;
    }
}
/* Solution from lee215
Intuition:
Consider trust as a graph, all pairs are directed edge.
The point with in-degree - out-degree = N - 1 become the judge.

Explanation:
Count the degree, and check at the end.

Time Complexity:
Time O(T + N), space O(N)
*/
/*
    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N+1];
        for (int[] t: trust) {
            count[t[0]]--;
            count[t[1]]++;
        }
        for (int i = 1; i <= N; ++i) {
            if (count[i] == N - 1) return i;
        }
        return -1;
    }
*/