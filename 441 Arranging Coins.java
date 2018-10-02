class Solution {
    public int arrangeCoins(int n) {
        if(n < 1)
            return 0;
        for(int i = 1; ;i++){
            n -=i;
            if(n < 0)
                return i-1;
        }
    }
}
/*
class Solution {
    public int arrangeCoins(int n) {
        if (n == 0 || n == 1) return n;
        long lo = 1, hi = n, x;
        while (lo < hi-1) {            
            x = hi - (hi - lo) / 2;
            System.out.printf("hi, lo, x = %d, %d, %d\n", hi, lo, x);
            long res;
            if ((x & 1) == 0) res = (x >> 1) * (1 + x);
            else res = ((1 + x) >> 1) * x;
            if (n == res)
                return (int) x;
            else if (n < res)
                hi = x;
            else
                lo = x;
        }
        return (int) lo;
    }
}
*/