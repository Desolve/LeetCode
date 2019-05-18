class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int lo = 1, up = num, mid;
        while (lo < up - 1) {
            mid = lo + (up - lo) / 2;
            int div = num / mid;
            System.out.printf("lo, up, mid, div = %d, %d, %d, %d\n", lo, up, mid, div);
            if (div == mid && num % mid == 0) 
                return true;
            else if (div > mid) {
                lo = mid;
            } else {
                up = mid;
            }
        }
        return false;        
    }
}
/* Faster solution:
class Solution {
    public boolean isPerfectSquare(int num) {
        int low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) >>> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }
}
*/