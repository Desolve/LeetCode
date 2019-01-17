class Solution {
    int cnt_O = 0, cnt_X = 0, n_d = 0;
    public boolean validTicTacToe(String[] board) {
        char[][] cells = new char[3][];
        for (int i = 0; i < 3; i++)
            cells[i] = board[i].toCharArray();
        if (!validNum(cells) || !validLines(cells, board)) return false;
        if (n_d == 0 && cnt_X == 1) return false;
        if (n_d == 1 && cnt_O == 1) return false;
        return true;
    }
    private boolean validLines(char[][] cells, String[] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i].equals("OOO")) cnt_O++;
            else if(board[i].equals("XXX")) cnt_X++;
            if (cells[0][i] == 'O' && cells[1][i] == 'O' && cells[2][i] == 'O') cnt_O++;
            else if (cells[0][i] == 'X' && cells[1][i] == 'X' && cells[2][i] == 'X') cnt_X++;
            if (cnt_O > 1) return false;
            if (cnt_X > 2) return false;
        }
        if (cells[1][1] == 'O') {
            if (cells[0][0] == 'O' && cells[2][2] == 'O') cnt_O++;
            if (cells[0][2] == 'O' && cells[2][0] == 'O') cnt_O++;
            if (cnt_O > 1) return false;
        } else if (cells[1][1] == 'X') {
            if (cells[0][0] == 'X' && cells[2][2] == 'X') cnt_X++;
            if (cells[0][2] == 'X' && cells[2][0] == 'X') cnt_X++;
            if (cnt_X > 2) return false;
        }
        if (cnt_O == 1 && cnt_X >= 1) return false;
        return true;
    }
    private boolean validNum(char[][] cells) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == 'X') n_d++;
                else if (cells[i][j] == 'O') n_d--;
            }
        }
        if (n_d == 1 || n_d == 0)
            return true;
        else
            return false;
    }
}

/* More concise solution from JustinCYZ
class Solution {
    public boolean validTicTacToe(String[] board) {
        char[][] result = new char[3][3];
        Boolean answer = false; 
        int X = 0;
        int O = 0;
        for(int i=0; i<3;i++){
            for(int j=0; j< 3; j++){
                if(board[i].charAt(j) =='O'){
                    O++;
                }else if(board[i].charAt(j) =='X'){
                    X++;
                }
               
                result[i][j] = board[i].charAt(j);
            }
        }
        if(O>X || X-O >1 ){ return answer;}
        if(checkValid(result, 'X') && checkValid(result, 'O')){ return answer;}
        if(checkValid(result, 'O') && X !=O){return answer;}
        if(checkValid(result, 'X') && X !=O+1){return answer;}
        
        return true;
    }
    
    public Boolean checkValid(char[][] result, char chess){
        for(int i=0;i<3;i++){
            if(result[i][0] == result[i][1] && result[i][1]==result[i][2] && result[i][2] == chess){
                return true;
            }
        }
         for(int i=0;i<3;i++){
              if(result[0][i] == result[1][i] && result[1][i]==result[2][i] && result[2][i] ==chess){
                return true;
            }
        }
         if(result[0][0]==result[1][1] && result[1][1] ==result[2][2] &&result[2][2]==chess ){
             return true;
         }
        if(result[2][0]==result[1][1] && result[1][1] ==result[0][2] &&result[0][2]==chess){
            return true;
        }
        return false;
    }
    
}
*/