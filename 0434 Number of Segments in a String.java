class Solution {
    public int countSegments(String s) {
        int len = s.length(), cnt = 1, i = 0;
        while (true) {
            if (i == len) return 0; 
            if (s.charAt(i) == ' ')
                i++;
            else
                break;
        }
        
        char last = 'a';
        
        for (; i < len; i++) {
            char now = s.charAt(i);
            if (now == ' ' && last != ' ') cnt++;
            last = now;
        }
        if (last == ' ') cnt--;
        return cnt;
    }
}