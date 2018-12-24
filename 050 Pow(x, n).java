class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        if (n < 0) {
            return 1 / x * myPow(1 / x, -(n + 1));
        } else {
            if (n % 2 != 0) {
                return x * myPow(x * x, n / 2);
            } else {
                return myPow(x * x, n / 2);
            }
        }
    }
}