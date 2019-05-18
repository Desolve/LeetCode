class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int len = costs.length;
        Comparator cmp = new CityComparator();
        Arrays.sort(costs, cmp);
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += (i < len / 2)? costs[i][0] :costs[i][1];
        }
        return sum;
    }
}
class CityComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] o1, int[] o2) {
        return (o1[0] - o1[1]) - (o2[0] - o2[1]);
    }
}

/* Faster that using diff
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int[] diff = new int[costs.length];
        int sum = 0;
        for(int i=0; i<costs.length; i++) {
            diff[i] = costs[i][0] - costs[i][1];
            sum += costs[i][0];
        }
        Arrays.sort(diff);
        for(int i=diff.length/2; i<diff.length; i++) {
            sum -= diff[i];
        }
        return sum;
    }
}
*/