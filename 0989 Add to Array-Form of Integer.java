class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        int digit = A.length - 1;
        while (K > 0 && digit >= 0) {
            int sum = A[digit] + K % 10;
            res.addFirst(sum % 10);
            K  = K / 10 + sum / 10;
            --digit;
        }
        if (K == 0) {
            while (digit >= 0)
                res.addFirst(A[digit--]);
            return res;
        } else {
            while (K > 0) {
                res.addFirst(K % 10);
                K /= 10;
            }
            return res;
        }
    }
}