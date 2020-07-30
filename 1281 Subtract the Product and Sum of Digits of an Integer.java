class Solution {
    public int subtractProductAndSum(int n) {
        int pr = 1;
        int s = 0;
        int i = n;
        while (i > 0) {
            int re = i % 10;
            pr *= re;
            s += re;
            i /= 10;            
        }
        return pr - s;
    }
}