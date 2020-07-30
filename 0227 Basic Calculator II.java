// Adapted from saybia1993
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        long pre = 0;
        int res = 0;
        char ops = '+';
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (c >= '0' && c <= '9') {
                int num = c - '0';
                while (i + 1 < s.length() && s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9') {
                    ++i;
                    num = num * 10 + (s.charAt(i) - '0');
                }                
                if (ops == '+') {
                    res += pre;
                    pre = num;
                } else if (ops == '-') {
                    res += pre;
                    pre = -num;
                } else if (ops == '*') {
                    pre *= num;
                } else if (ops == '/') {
                    pre /= num;
                }
            } else {
                ops = c;
            }
        }
        res += pre;
        return res;
    }
}