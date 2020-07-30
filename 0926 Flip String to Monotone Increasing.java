class Solution {
    public int minFlipsMonoIncr(String S) {
        int f0 = 0, f1 = 0;
        for (char c: S.toCharArray()) {
            if (c == '0') {
                ++f1;
            } else {
                f1 = Math.min(f0, f1);
                ++f0;
            }
        }
        return Math.min(f0, f1);
    }
}