class Solution {
    public int findNthDigit(int n) {
        n -= 1;
        int digits = 1, first = 1;
        while (n / 9 / first / digits >= 1) {
            n -= 9 * first * digits;
            digits++;
            first *= 10;
        }
        return (first + n/digits + "").charAt(n%digits) - '0';
    }
}