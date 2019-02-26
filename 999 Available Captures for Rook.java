class Solution {
    public int numRookCaptures(char[][] board) {
        int r = 0, c = 0, cnt = 0;
        boolean found = false;
        while (r < 8 && !found) {
            c = 0;
            while (c < 8 && !found) {
                if (board[r][c] == 'R') 
                    found = true;
                else
                    ++c;
            }
            if (!found) ++r;
        }
        
        int i = r;
        while (++i < 8) {
            if (board[i][c] == 'B') break;
            else if (board[i][c] == 'p') {
                ++cnt;
                break;
            }
        }
        i = r;
        while (--i >= 0) {
            if (board[i][c] == 'B') break;
            else if (board[i][c] == 'p') {
                ++cnt;
                break;
            }
        }
        int j = c;
        while (++j < 8) {
            if (board[r][j] == 'B') break;
            else if (board[r][j] == 'p') {
                ++cnt;
                break;
            }
        }
        j = c;
        while (--j >= 0) {
            if (board[r][j] == 'B') break;
            else if (board[r][j] == 'p') {
                ++cnt;
                break;
            }
        }
        return cnt;
    }
}