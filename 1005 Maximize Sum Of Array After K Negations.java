class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int x: A) pq.add(x);
        while( K--  > 0) pq.add(-pq.poll());
  
        int sum  = 0;
        for(int i = 0; i < A.length; i++){
            sum += pq.poll();
        }
        return sum;
    }
}

/* Beat 100% by JPV
class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        for (int i = 0, j = 0; i < K; i++, A[j] = -A[j]) if (j+1 < A.length && A[j+1] < A[j]) j++;
        int sum = 0;
        for (int i = 0; i < A.length; i++) sum += A[i];
        return sum;
    }
}*/