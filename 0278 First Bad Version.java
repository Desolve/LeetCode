/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n == 1 || n == 0) return n;
        int lo = 1, up = n;
        while (lo < up) {
            int mid = lo + (up - lo) / 2;
            if (isBadVersion(mid)) up = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}