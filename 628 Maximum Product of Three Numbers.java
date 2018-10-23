/*
選取數字的狀況分類
當不含0:
ppp ppn pnn nnn
ppp, ppn, nnn均可用max1*max2*max3來概括(因p和n都要取盡可能大)
pnn可用max1*min1*min2來包含(因p要取盡可能大，n要取盡可能小乘起來才會最大)

考慮0的時候:
ppn代表p只有2個，故如有0的話ppz可用max1*max2*max3來概括
nnn代表沒有p，故有0的話znn也可用max1*max2*max3來概括
其他ppp和pnn均大於0，故肯定比含0的狀況大，故可不納入

因此本題的所有狀況均可以用max1*max2*max3和max1*min1*min2來包含，
我們只需要取兩者較大的値即可，不需要考慮是否有0在其中。

*/
class Solution {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i: nums) {
            if (i > max1) {
                max3 = max2;
                max2 = max1;
                max1 = i;
            } else if (i > max2) {
                max3 = max2;
                max2 = i;
            } else if (i > max3) {
                max3 = i;
            }
            if (i < min1) {
                min2 = min1;
                min1 = i;
            } else if (i < min2) {
                min2 = i;
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);        
    }
}