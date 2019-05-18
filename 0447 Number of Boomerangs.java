class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        HashMap<Integer, Integer> dMap = new HashMap<Integer, Integer>();
        for(int[] i: points) {
            for(int[] j: points){
                if (i == j) continue;
                int dist = (i[0]-j[0])*(i[0]-j[0]) + (i[1]-j[1])*(i[1]-j[1]);
                int prevD = dMap.getOrDefault(dist, 0);
                result += prevD * 2;
                dMap.put(dist, prevD+1);
            }
            dMap.clear();
        }
        return result;
    }
}