class Solution {    
    public static final int d_up = 0, d_down = 1, d_left = 2, d_right = 3;
    public int row, col;
    public int oriColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        row = image.length;
        col = image[0].length;
        oriColor = image[sr][sc];
        image[sr][sc] = newColor;
        flood(image, sr, sc, newColor, d_up);
        flood(image, sr, sc, newColor, d_down);
        flood(image, sr, sc, newColor, d_left);
        flood(image, sr, sc, newColor, d_right);
        return image;
    }
    public void flood(int[][] image, int r, int c, int newColor, int dir) {
        int tr = -1, tc = -1;
        switch (dir) {
            case d_up:
                tr = r - 1; tc = c;
                if (tr < 0) return;
                break;
            case d_down:
                tr = r + 1; tc = c;
                if (tr >= row) return;
                break;
            case d_left:
                tc = c - 1; tr = r;
                if (tc < 0) return;
                break;
            case d_right:
                tc = c + 1; tr = r;
                if (tc >= col) return;
                break;
            default:
                break;
        }
        if (image[tr][tc] == newColor) return;
        if (image[tr][tc] != oriColor) return;
        image[tr][tc] = newColor;
        flood(image, tr, tc, newColor, d_up);
        flood(image, tr, tc, newColor, d_down);
        flood(image, tr, tc, newColor, d_left);
        flood(image, tr, tc, newColor, d_right);
    }
}

/* Cleaner and Faster code
class Solution {    
    public static final int d_up = 0, d_down = 1, d_left = 2, d_right = 3;
    public int row, col;
    public int oriColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        row = image.length;
        col = image[0].length;
        oriColor = image[sr][sc];
        image[sr][sc] = newColor;
        flood(image, sr + 1, sc, newColor);
        flood(image, sr - 1, sc, newColor);
        flood(image, sr, sc + 1, newColor);
        flood(image, sr, sc - 1, newColor);
        return image;
    }
    public void flood(int[][] image, int sr, int sc, int newColor) {
        if (sr < 0 || sr >= row || sc < 0 || sc >= col || image[sr][sc] != oriColor) return;
        if (image[sr][sc] == newColor) return;
        if (image[sr][sc] != oriColor) return;
        image[sr][sc] = newColor;
        flood(image, sr + 1, sc, newColor);
        flood(image, sr - 1, sc, newColor);
        flood(image, sr, sc + 1, newColor);
        flood(image, sr, sc - 1, newColor);
    }
}
*/