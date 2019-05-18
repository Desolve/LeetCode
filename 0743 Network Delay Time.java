class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        if (times == null || times.length == 0) return -1;
        
        // u: source, v: target, w: distance <= time[0 to 2]
        Map<Integer, Map<Integer, Integer>> path = new HashMap<>();
        for (int[] time : times) {
            Map<Integer, Integer> srcMap = path.get(time[0]);
            if (srcMap == null) {
                srcMap = new HashMap<>();
                path.put(time[0], srcMap);
            }
            Integer d = srcMap.get(time[1]);
            if (d == null || d > time[2]) srcMap.put(time[1], time[2]);
        }
        
        Map<Integer, Integer> dMap = new HashMap<>();
        dMap.put(K, 0); // start point for Dijkstra
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> { return i1[1] - i2[1]; });
        pq.offer(new int[]{K, 0});
        int res = -1;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int dist = cur[1];
            if (dMap.containsKey(node) && dMap.get(node) < dist) continue;
            Map<Integer, Integer> srcMap = path.get(node);
            if (srcMap == null) continue;
            for (Map.Entry<Integer, Integer> entry : srcMap.entrySet()) {
                int absDist = dist + entry.getValue();
                int tarNode = entry.getKey();
                if (dMap.containsKey(tarNode) && dMap.get(tarNode) <= absDist) continue; // find min d[a]+w[a][b]
                dMap.put(tarNode, absDist);
                pq.offer(new int[]{tarNode, absDist});
            }
        }
        // Get the max abs distance, if there's node that cannot be reached, return -1.
        for (int value : dMap.values()) {
            if (value > res) res = value;
        }
        return dMap.size() == N ? res : -1; 
    }
}
/* Solution from CLLcode which beats 98.22% 
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[] visited = new int[N+1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[K] = 0;
        visited[0] = 0;
        int[][] graph = new int[N+1][N+1];
        // graph default non-connected
        for(int i = 0; i < N+1; i++){
            Arrays.fill(graph[i], -1);
        }
        // Build up the graph
        for(int[] time : times){
            graph[time[0]][time[1]] = time[2];
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(K);
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int i = 1; i <= N; i++){
                if(graph[curr][i] >= 0 && visited[i] > visited[curr] + graph[curr][i]){  // d[a]+w[a][b] < d[b] => update d[b]
                    q.offer(i);
                    visited[i] = visited[curr] + graph[curr][i];
                }
            }
        }
        // Check if there's any unvisited vertex
        int max = 0;
        for(int v : visited){
            max = Math.max(v, max);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}
*/

/* Bellman-Ford algorithm, Time complexity: O(N*E), Space complexity: O(N) by lakemorning
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        double[] disTo = new double[N];
        Arrays.fill(disTo, Double.POSITIVE_INFINITY);
        disTo[K - 1] = 0;
        for (int i = 1; i < N; i++) {
            for (int[] edge : times) {
                int u = edge[0] - 1, v = edge[1] - 1, w = edge[2];
                disTo[v] = Math.min(disTo[v], disTo[u] + w);
            }
        }
        double res = Double.MIN_VALUE;
        for (double i: disTo) {
            res = Math.max(i, res);
        }
        return res == Double.POSITIVE_INFINITY ? -1 : (int) res;
    }
}
*/