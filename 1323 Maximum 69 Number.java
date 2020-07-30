class Solution {
    public int maximum69Number (int num) {
        return Integer.valueOf(String.valueOf(num).replaceFirst("6", "9"));
    }
}
/* 0 ms solution
class Solution {
    public int maximum69Number (int num) {
        int i = 1, n = num, i6 = -1;
        while (n > 0) {
            if (n % 10 == 6) i6 = i;
            n /= 10;
            i *= 10;
        }

        return (i6 == -1)? num : num + 3 * i6;        
    }
}*/