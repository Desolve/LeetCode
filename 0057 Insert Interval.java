// adapted from Lenaxiao
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval == null || newInterval.length == 0) return intervals;
        int s = newInterval[0];
        int e = newInterval[1];
        boolean add = false;
        List<int[]> res = new ArrayList<>();
        for (int[] itv : intervals) {
            if (!add) {
                if (itv[0] <= e && itv[1] >= s) { // overlapping
                    s = Math.min(itv[0], s);
                    e = Math.max(itv[1], e);
                } else if (itv[1] < s) {
                    res.add(itv);
                } else {
                    res.add(new int[] {s, e});
                    res.add(itv);
                    add = true; // no other overlapping
                }
            } else {
                res.add(itv);
            }
        }
        if (!add) {
            res.add(new int[] {s, e});
        }
        int[][] result = new int[res.size()][2];
        int i = 0;
        for (int[] itv : res) {
            result[i++] = itv;
        }
        return result;
    }
}
