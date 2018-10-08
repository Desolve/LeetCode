class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) return 9;
        int max = (int)Math.pow(10, n) - 1;
        for (int v = max - 1; v > max / 10; v--) {
            long p = Long.valueOf(v + new StringBuilder().append(v).reverse().toString());
            for (long x = max; x * x >= p; x--) {
                if (p % x == 0)
                    return (int) (p % 1337);
            }
        }
        return 0;
    }
}

/* 因為最高只限定8位數:
public class Solution {
    public int largestPalindrome(int n) {
        int[] x = {9,99,993,9999,99979,999999,9998017,99999999};
        int[] y = {1,91,913,9901,99681,999001,9997647,99990001};
        
        return ((x[n-1]%1337)*(y[n-1]%1337))%1337;
    }
}

Or:

return (-14535*(n%2)+8730*(n%3)+3780*(n%4)-426*(n%5)-2180*(n%6)+1500*(n%7)+3285*(n%8)+116*(n%9))/30;
*/