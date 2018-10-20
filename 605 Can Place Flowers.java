class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cnt = 0;
        for (int i = 0; i < flowerbed.length && cnt < n; ++i) {
            if (flowerbed[i] == 0) {
                int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
                int prev = (i == 0) ? 0 : flowerbed[i - 1];
                if (next == 0 && prev == 0) {
                    flowerbed[i] = 1;
                    ++cnt;
                }
            }
        }
        return (cnt == n);
    }
}

/* Faster solution(clean code)
class Solution {
    public boolean canPlaceFlowers(int[] bed, int n) {
        for (int i = 0; i < bed.length; i++) {
            if (bed[i] == 0 && (i == 0 || bed[i - 1] == 0) && (i == bed.length - 1 || bed[i + 1] == 0)) {
                bed[i] = 1;
                n--;
            }
        }
        return n <= 0;        
    }
}
*/