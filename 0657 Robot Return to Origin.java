class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (int i = 0; i < moves.length(); ++i) {
            char move = moves.charAt(i);
            if (move == 'U') ++y;
            else if (move == 'D') --y;
            else if (move == 'R') ++x;
            else --x;
        }
        return (x == 0) && (y == 0);
    }
}

/* toCharArray is faster
class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char move: moves.toCharArray()) {
            if (move == 'U') y--;
            else if (move == 'D') y++;
            else if (move == 'L') x--;
            else if (move == 'R') x++;
        }
        return x == 0 && y == 0;
    }
}
*/