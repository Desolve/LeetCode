class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return (Math.max(rec1[0],rec2[0])<Math.min(rec1[2],rec2[2]) && Math.max(rec1[1],rec2[1])<Math.min(rec1[3],rec2[3]));
    }
}

/* Better solution
// The rec1's x1 must be smaller than the rec2's x2, and vice versa, otherwise they won't even met.
// So are y1/y2 conditions.
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return rec1[0] < rec2[2] && rec2[0] < rec1[2] && rec1[1] < rec2[3] && rec2[1] < rec1[3];
    }
}
*/