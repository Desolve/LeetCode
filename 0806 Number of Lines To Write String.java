class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int[] res = new int[]{1, 0};
        for (char ch : S.toCharArray()) {
            int w = widths[ch - 'a'];
            if (res[1] + w > 100) {
                ++res[0];
                res[1] = w;
            } else res[1] += w;
        }
        return res;
    }
}