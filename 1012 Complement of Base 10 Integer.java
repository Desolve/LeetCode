class Solution {
    public int bitwiseComplement(int N) {
        int X = 1;
        while (N > X) X = X * 2 + 1;
        return X - N;
    }
}

/* Solution from msalto
class Solution {
    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        int mask = (1 << 30);
        while ((mask & N) == 0) {
            mask >>= 1;
        }
        return (mask - 1) & (~N);
    }
}
*/