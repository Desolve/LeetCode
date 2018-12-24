class Solution {
    public String dot;
    public List<List<String>> solveNQueens(int n) {
        int[] board = new int[n]; // board[i] is the i-th row's Queen position column
        String s = ".";
        dot = String.join("", Collections.nCopies(n - 1, s));
        List<List<String>> res = new ArrayList<>();
        findSol(res, board, n, 0);
        return res;
    }
    public void findSol(List<List<String>> res, int[] board, int n, int r) {
        Queue<Integer> q = new LinkedList<>();
        for (int p = 0; p < n; p++) {
            boolean valid = true;
            for (int j = 0; j < r; j++) {
                if (board[j] == p || (Math.abs(board[j] - p) == Math.abs(j - r))) {
                    valid = false;
                    break;
                }
            }
            if (valid) q.offer(p);
        }
        
        if (r == n-1) {
            if (!q.isEmpty()) {
                board[r] = q.poll();
                addSolution(res, board);
            }
        } else {
            while (!q.isEmpty()) {
                board[r] = q.poll();
                findSol(res, board, n, r + 1);
            }
        }
    }
    
    public void addSolution(List<List<String>> res, int[] board) {
        int n = board.length;
        List<String> sol = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = dot.substring(0, board[i]) + "Q" + dot.substring(board[i], n - 1);
            sol.add(str);
        }
        res.add(sol);
    }
}