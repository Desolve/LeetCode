class Solution {
    public int hammingDistance(int x, int y) {
        int ham = x ^ y;
        int d = 0;
        while (ham != 0) {
            d += ham & 1;
            ham >>= 1;
        }
        return d;
    }
}

/*
class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
*/