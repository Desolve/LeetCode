// Counting sort from nullpointer01
class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[] counter = new int[R + C + 1];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int dist = Math.abs(r - r0) + Math.abs(c - c0);
                counter[dist + 1] += 1;
            }
        }
        
        for (int i = 1; i < counter.length; i++) {
            counter[i] += counter[i - 1];
        }
        
        int[][] ans = new int[R * C][];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int dist = Math.abs(r - r0) + Math.abs(c - c0);
                ans[counter[dist]] = new int[] { r, c };
                counter[dist]++;
            }
        }
        
        return ans;
    }
}

/*
// BFS solution (slower)
class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        boolean[][] visited = new boolean[R][C];
        int[][] res = new int[R * C][2];
        int i = 0;
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{r0, c0});
        while (!q.isEmpty()) {
            int[] n = q.poll();
            int r = n[0];
            int c = n[1];
            
            if (r < 0 || r >= R || c < 0 || c >= C) continue;
            if (visited[r][c]) continue;
            
            res[i++] = n;
            visited[r][c] = true;
            q.offer(new int[]{r - 1, c});
            q.offer(new int[]{r + 1, c});
            q.offer(new int[]{r, c - 1});
            q.offer(new int[]{r, c + 1});
        }
        return res;
    }
}
*/