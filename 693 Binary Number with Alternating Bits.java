class Solution {
    public boolean hasAlternatingBits(int n) {
        return ( ((long)n + (n>>1) + 1) & ( (long)n + (n>>1) )) == 0;
    }
}

/*
    n =         1 0 1 0 1 0 1 0
    n >> 1      0 1 0 1 0 1 0 1
    n ^ n>>1    1 1 1 1 1 1 1 1
    n           1 1 1 1 1 1 1 1
    n + 1     1 0 0 0 0 0 0 0 0
    n & (n+1)   0 0 0 0 0 0 0 0
*/
/* Beat 94.83%
class Solution {
    public boolean hasAlternatingBits(int n) {
        n = n ^ (n>>1);
        return (n & n+1) == 0;
    }
}
*/

/* Alternative solution
class Solution {
    public boolean hasAlternatingBits(int n) {
        String binary = Integer.toBinaryString(n);
        return !binary.contains("00") && !binary.contains("11");
    }
}
*/