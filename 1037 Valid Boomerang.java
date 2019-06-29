class Solution {
    public boolean isBoomerang(int[][] points) {
        int[] a, b, c;
        a = points[0];
        b = points[1];
        c = points[2];
        if (a == b || b == c || c == a)
            return false;
        return !((b[1] - a[1]) * (c[0] - a[0]) == (c[1] - a[1]) * (b[0] - a[0]));
    }
}