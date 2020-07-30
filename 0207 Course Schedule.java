// Adapted from lee215, BFS Topological Sorting, O(N+E) (3ms)
class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {        
        ArrayList<Integer>[] graph = new ArrayList[n];
        int[] degree = new int[n];
        ArrayList<Integer> bfs = new ArrayList();
        for (int i = 0; i < n; ++i) graph[i] = new ArrayList<Integer>();
        for (int[] edge: prerequisites) {
            graph[edge[1]].add(edge[0]);
            degree[edge[0]]++;
        }
        for (int i = 0; i < n; ++i) if (degree[i] == 0) bfs.add(i);
        for (int i = 0; i < bfs.size(); ++i) {
            for (int j: graph[bfs.get(i)]) {
                if (--degree[j] == 0) bfs.add(j);
            }
        }
        return bfs.size() == n;
    }
}
/* Faster than 100% (1ms), adapted from the answer
class Solution {    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return true;

        int[] in = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++)
            in[prerequisites[i][1]]++;

        boolean visited[] = new boolean[prerequisites.length];
        boolean change = true;
        while (change) {
            change = false;
            for (int i = 0; i < prerequisites.length; i++) {
                if (!visited[i]) {
                    if (in[prerequisites[i][0]] == 0 && in[prerequisites[i][1]] != 0) {
                        visited[i] = true;
                        in[prerequisites[i][1]]--;
                        change = true;
                    }
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (in[i] != 0)
                return false;
        }
            return true;

    }
}*/