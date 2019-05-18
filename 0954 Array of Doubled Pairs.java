class Solution {
    public boolean canReorderDoubled(int[] A) {
        int[] pos = new int[100001];
        int[] neg = new int[100001];
        for (int n : A) {
            if (n >= 0) pos[n]++;
            else neg[-n]++;
        }
        if (pos[0] % 2 == 1) return false;
        else {
            for (int i = 100000; i > 0; --i) {
                if (pos[i] != 0 || neg[i] != 0) {
                    if (i % 2 != 0) return false;
                    pos[i / 2] -= pos[i];
                    neg[i / 2] -= neg[i];
                    if (pos[i / 2] < 0 || neg[i / 2] < 0) return false;
                }
                
            }
        }
        return true;
    }
}