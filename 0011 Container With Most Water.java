class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length - 1; ++i) {
            for (int j = i + 1; j < height.length; ++j) {
                int vol = (j - i) * Math.min(height[i], height[j]);
                res = Math.max(res, vol);
            }
        }
        return res;
    }
}
/* Much faster solution.
class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int i = 0, j = height.length - 1, diff = j - i;
        while (i < j) {
            int h1 = height[i];
            int h2 = height[j];
            int vol = diff * Math.min(height[i], height[j]);
            res = Math.max(res, vol);
            if (h1 < h2) {
                ++i;
            } else {
                --j;
            }
            --diff;            
        }
        return res;
    }
}*/