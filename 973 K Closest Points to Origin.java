class Solution {
    class sortByDist implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return (a[0]*a[0] + a[1]*a[1]) < (b[0]*b[0] + b[1]*b[1]) ? -1 : 1;
        }
    }
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, new sortByDist());
        return Arrays.copyOfRange(points, 0, K);
    }
}

/* Slower using lambda expression from lee215
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparing(p -> p[0] * p[0] + p[1] * p[1]));
        return Arrays.copyOfRange(points, 0, K);
    }
}
*/