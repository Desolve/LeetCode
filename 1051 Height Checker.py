class Solution:
    def heightChecker(self, heights: List[int]) -> int:
        heightfreq = [0] * 101;
        for height in heights:
            heightfreq[height] += 1;
        
        res = 0;
        currheight = 1;
        l = len(heights)
        
        for i in range(0, l):
            while heightfreq[currheight] == 0: currheight += 1;
            if currheight != heights[i]: res += 1;            
            heightfreq[currheight] -= 1;
        return res;