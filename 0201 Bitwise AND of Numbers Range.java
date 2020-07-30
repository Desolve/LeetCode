class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int factor = 0;
        while (m != n){
            m >>= 1;
            n >>= 1;
            ++factor;
        }
        return m << factor;
    }
}

/* The other solution
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int factor = 1;
        while (m != n){
            m >>= 1;
            n >>= 1;
            factor <<= 1;
        }
        return m * factor;
    }
}

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        while (n > m){
            n &= n-1;
        }
        return n;
    }
}
*/