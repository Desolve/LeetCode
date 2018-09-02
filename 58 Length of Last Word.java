class Solution {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        if(s == null || end + 1 == 0) return 0;
        int i = end;
        while(i >= 0 && s.charAt(i) == ' ') i--;
        if(i < 0) return 0;
        end = i;
        while(i >= 0 && s.charAt(i) != ' ') i--;
        return end - i;
    }
}