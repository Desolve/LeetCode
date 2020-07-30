class Solution {
    public int minCostToMoveChips(int[] chips) {
        int[] pair = new int[2];
        for (int pos: chips)
            ++pair[pos & 1];

        if (pair[0] < pair[1]) 
            return pair[0];
        else
            return pair[1];
    }
}