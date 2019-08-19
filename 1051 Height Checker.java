class Solution {
    public int heightChecker(int[] heights) {
        int[] heightfreq = new int[101];
        for (int height: heights) {
            heightfreq[height]++;
        }
        
        int res = 0;
        int currheight = 1;
        
        for (int i = 0; i < heights.length; ++i) {
            while (heightfreq[currheight] == 0) currheight++;
            if (currheight != heights[i]) res++;            
            heightfreq[currheight]--;
        }
        return res;
    }
}