class Solution {
    public String reverseOnlyLetters(String S) {
        char[] chs = S.toCharArray();
        int l = 0, r = chs.length - 1;
        while (l < r) {
            while (l < r && !Character.isLetter(chs[l])) ++l;
            while (l < r && !Character.isLetter(chs[r])) --r;
            
            char tmp = chs[l];
            chs[l] = chs[r];
            chs[r] = tmp;
            ++l; 
            --r;
        }
        return String.valueOf(chs);
    }
}