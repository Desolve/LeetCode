class Solution {
    final int RIGHT = 0, DOWN = 1, LEFT = 2, UP = 3;
    int m;
    int n;
    boolean[][] visited;
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        m = matrix.length;
        n = matrix[0].length;
        visited = new boolean[m][n];
        spiral(res, matrix, 0, 0, false, RIGHT);
        return res;
    }
    public void spiral(List<Integer> res, int[][] matrix, int i, int j, boolean turned, int dir) {
        if (!visited[i][j]) {
            visited[i][j] = true;
            res.add(matrix[i][j]);
        }
        switch (dir) {
            case RIGHT:
                if (j + 1 < n && !visited[i][j + 1]) spiral(res, matrix, i, j + 1, false, RIGHT);
                else if (!turned) spiral(res, matrix, i, j, true, DOWN);
                break;
            case DOWN:
                if (i + 1 < m && !visited[i + 1][j]) spiral(res, matrix, i + 1, j, false, DOWN);
                else if (!turned) spiral(res, matrix, i, j, true, LEFT);
                break;
            case LEFT:
                if (j - 1 >= 0 && !visited[i][j - 1]) spiral(res, matrix, i, j - 1, false, LEFT);
                else if (!turned) spiral(res, matrix, i, j, true, UP);
                break;
            case UP:
                if (i - 1 >= 0 && !visited[i - 1][j]) spiral(res, matrix, i - 1, j, false, UP);
                else if (!turned) spiral(res, matrix, i, j, true, RIGHT);
                break;
            default:
                break;
        }
    }
}

/* 1 ms without recursion
class Solution {
    int m;
    int n;
    boolean[][] visited;
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        m = matrix.length;
        n = matrix[0].length;
        visited = new boolean[m][n];
        int len = m * n;
        int[] p = new int[]{0, 0};
        int[] dir = new int[]{0, 1};
        
        for (int c = 0; c < len; c++) {
            int x = p[0], y = p[1];
            res.add(matrix[x][y]);
            visited[x][y] = true;
            next(p, dir);
        }
        return res;
    }
    public void next(int[] p, int[] dir) {
        int x = p[0], y = p[1];
        if (dir[0] == 0 && dir[1] == 1) {
            if (y + 1 < n && !visited[x][y + 1]) 
                p[1]++;
            else { 
                dir[0] = 1; 
                dir[1] = 0; 
                p[0]++; 
            }
        } else if (dir[0] == 1 && dir[1] == 0) {
            if (x + 1 < m && !visited[x + 1][y]) 
                p[0]++;
            else { 
                dir[0] = 0; 
                dir[1] = -1; 
                p[1]--; 
            }
        } else if (dir[0] == 0 && dir[1] == -1) {
            if (y - 1 >= 0 && !visited[x][y - 1]) 
                p[1]--;
            else { 
                dir[0] = -1; 
                dir[1] = 0; 
                p[0]--; 
            }
        } else {
            if (x - 1 >= 0 && !visited[x - 1][y]) 
                p[0]--;
            else { 
                dir[0] = 0; 
                dir[1] = 1; 
                p[1]++; 
            }
        }
    }
}
*/

/* rotate
class Solution {
    public static List<Integer> spiralOrder(int[][] matrix) {        
        List<Integer> list = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0) return list;
        rotate(matrix,list);        
        return list;
    }

    public static void rotate(int[][] matrix, List<Integer> list) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(m == 0 || n == 0)return;
        for(int i = 0; i < n; i++){
            list.add(matrix[0][i]);
        }
        int[][] a = new int[n][m-1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m-1; j++) {
                a[i][j] = matrix[j+1][n-1-i];
            }           
        }
        rotate(a,list);     
    }
}
*/