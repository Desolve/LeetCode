class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        while (n > 0) {
            if ((n & 1) == 0)
                n >>= 1;
            else
                break;
        }
        if (n >> 1 > 0) 
            return false;
        else
            return true;
    }
}
/* Using Integer.bitCount
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n>0 && Integer.bitCount(n) == 1;
    }
}

Using Difference
class Solution {
    public boolean isPowerOfTwo(int n) {
        return ( n>0 && (n & (n-1))==0 );
    }
}
*/