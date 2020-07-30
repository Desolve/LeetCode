class Solution {
    public String tictactoe(int[][] moves) {
        int[] cols = new int[3], rows = new int[3], diags = new int[2];
        int val = 1, cnt = 0;
        for (int[] move : moves) {
            int i = move[0], j = move[1];
            rows[i]+= val; cols[j] += val;
            if (i == j) diags[0] += val;
            if (i + j == 2) diags[1] += val;
            
            if (rows[i] == 3 || rows[i] == -3) return rows[i] == 3 ? "A" : "B";
            else if (cols[j] == 3 || cols[j] == -3) return cols[j] == 3 ? "A" : "B";
            else if (diags[0] == 3 || diags[0] == -3 || diags[1] == 3 || diags[1] == -3)
                return (diags[0] == 3 || diags[1] == 3) ? "A" : "B";
            val = -val;
            ++cnt;
        }
        
        return cnt == 9 ? "Draw" : "Pending";        
    }
}