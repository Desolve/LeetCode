class Solution {
    boolean[][] rowcheck; // num of row, num
    boolean[][] colcheck; // num of col, num
    boolean[][] sqacheck; // num of square block, num
    public void solveSudoku(char[][] board) {
        rowcheck = new boolean[9][9];
        colcheck = new boolean[9][9];
        sqacheck = new boolean[9][9];
        initCheck(board);
        solve(board, 0);
    }
    public boolean solve(char[][] board, int cell) {
        int i = cell / 9, j = cell % 9;
        if (board[i][j] != '.') {
            if (cell == 80) return true;
            return solve(board, cell + 1);
        } else {            
            boolean[] valid = new boolean[9];
            Queue<Integer> q = new LinkedList<>(); // Save those possible values
            for (int n = 0; n < 9; n++) {
                valid[n] = !(rowcheck[i][n] || colcheck[j][n] || sqacheck[(i / 3) * 3 + (j / 3)][n]);
                if (valid[n]) q.offer(n);
            }
            if (q.isEmpty()) {
                return false;
            } else {
                if (cell == 80) {  
                    board[8][8] = (char) ('1' + q.poll());
                    return true;
                }                
                while (q.size() > 0) {
                    int n = q.poll();
                    setN(board, i, j, n);
                    if (solve(board, cell + 1)) return true;
                    unsetN(board, i, j, n);
                }
                return false;
            }
        }
    }
    public void setN(char[][] board, int i, int j, int n) {
        board[i][j] = (char)('1' + n);
        rowcheck[i][n] = true;
        colcheck[j][n] = true;
        sqacheck[(i / 3) * 3 + (j / 3)][n] = true;
    }
    public void unsetN(char[][] board, int i, int j, int n) {
        board[i][j] = '.';
        rowcheck[i][n] = false;
        colcheck[j][n] = false;
        sqacheck[(i / 3) * 3 + (j / 3)][n] = false;
    }
    public void initCheck(char[][] board) {
        Queue<Integer> q = new LinkedList<>(); // Store where '.' are.
        // Set the numbers that already on the boards, and offer the '.'s to the queue for later check
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    int n = (int) (ch - '1');
                    rowcheck[i][n] = true;
                    colcheck[j][n] = true;
                    sqacheck[(i / 3) * 3 + (j / 3)][n] = true;
                } else {
                    q.offer(i * 9 + j);
                }
            }
        }
        // Find those cells that only have one solution and set it first.
        while (!q.isEmpty()) {
            int cell = q.poll();
            int i = cell / 9, j = cell % 9;
            boolean[] valid = new boolean[9];
            int cnt = 0, num = 0;
            for (int n = 0; n < 9; n++) {
                valid[n] = !(rowcheck[i][n] || colcheck[j][n] || sqacheck[(i / 3) * 3 + (j / 3)][n]);
                if (valid[n]) {
                    cnt++;
                    if (cnt == 1) num = n;
                    else break;
                }
            }
            if (cnt == 1) 
                setN(board, i, j, num);
        }
    }
}