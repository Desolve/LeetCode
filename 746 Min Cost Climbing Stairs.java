// Bottom-up solution
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) return 0;
        int i;
        for (i = 2; i < cost.length; ++i) {
            cost[i] += Math.min(cost[i-2], cost[i-1]);
        }
        return Math.min(cost[i-1], cost[i-2]);
    }
}

/* Top-down solution
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length];
        if(cost.length == 2)
            return Math.min(cost[0], cost[1]);
        
        int cost1 = findMin(cost, 0, memo);
        int cost2 = findMin(cost, 1, memo);
        
        return Math.min(cost1, cost2);
    }
    
    int findMin(int[] cost, int i, int[] memo) {
        if(i == cost.length-1 || i == cost.length-2)
            return cost[i];
        if(memo[i] > 0) return memo[i];
        
        int cost1 = findMin(cost, i+1, memo) + cost[i];
        int cost2 = findMin(cost, i+2, memo) + cost[i];
       
        memo[i] = Math.min(cost1, cost2);
        
        return Math.min(cost1, cost2);
    }
}
*/