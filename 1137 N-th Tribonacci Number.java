class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;        
        
        int n0 = 0, n1 = 1, n2 = 1;
        for (int i = 3; i <= n; ++i) {
            int temp = n0 + n1 + n2;
            n0 = n1;
            n1 = n2;
            n2 = temp;
        }
        return n2;
    }
}