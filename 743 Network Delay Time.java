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