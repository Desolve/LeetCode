class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int z = Math.max(a, Math.max(b, c));
        int x = Math.min(a, Math.min(b, c));
        int y = a + b + c - x - z;
        int[] res = new int[2];
        
        if (z - y == 1 && y - x == 1) {
            return res;
        } else if (z - y == 1 || y - x == 1) {
            res[0] = 1;
        } else if (z - y == 2 || y - x == 2) {
            res[0] = 1;
        } else {
            res[0] = 2;
        }
        
        res[1] = z - x - 2;
        return res;
    }
}