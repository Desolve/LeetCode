class Solution {
    public int divide(int dividend, int divisor) {
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int flag = (dividend < 0 != divisor < 0)? -1 : 1;
        if (divisor == 0) return Integer.MAX_VALUE;
        long res = cal(a, b);
        res = (flag == -1) ? -res : res;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        else
            return (int) res;
    }
    public long cal(long a, long b) {
        if (a < b) return 0;
        long sum = a;
        long res = 0;
        while (a >= b) {
            long cnt = 0;
            while (a >= (b << cnt)) ++cnt;
            --cnt;
            res += (long)1 << cnt;
            a -= b << cnt;
        }
        return res;
    }
}

/* No Use of Long Java Solution from siyang3
public class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
        if(dividend > 0 && divisor > 0) return divideHelper(-dividend, -divisor);
        else if(dividend > 0) return -divideHelper(-dividend,divisor);
        else if(divisor > 0) return -divideHelper(dividend,-divisor);
        else return divideHelper(dividend, divisor);
    }
    
    private int divideHelper(int dividend, int divisor){
        // base case
        if(divisor < dividend) return 0;
        // get highest digit of divisor
        int cur = 0, res = 0;
        while((divisor << cur) >= dividend && divisor << cur < 0 && cur < 31) cur++;
        res = dividend - (divisor << cur-1);
        if(res > divisor) return 1 << cur-1;
        return (1 << cur-1)+divide(res, divisor);
    }
}
*/