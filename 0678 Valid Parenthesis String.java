/* 1. Let all '*' become '(',
   check if '(' is enough for pairing ')'
   (From left to right)

   l < 0 during the for-loop -> false, since a ')' can't be paired.
   no '(' remains after pairing -> true
   l > 0 -> Go step 2

   2. Let all '*' become ')',
   check if ')' is enough for pairing '('
   (From left to right)

   The logic goes the same as step 1.
   If we could have enough '(' for pairing from left to right
   and have enough ')' for pairing from right to left,
   we can always let remain '*' as empty string,
   since we can't have real '(' or ')' as the remain part.
   (One of the direction will meet < 0 situation)

*/
class Solution {
    public boolean checkValidString(String s) {
        int l = 0, r = 0, n = s.length();
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(' || s.charAt(i) == '*') ++l;
            else --l;
            if (l < 0) return false;
        }
        if (l == 0) return true;
        
        for (int i = n - 1; i >= 0; --i) {
            if (s.charAt(i) == ')' || s.charAt(i) == '*') ++r;
            else --r;
            if (r < 0) return false;
        }
        return true;
    }
}

/* Solution from lee215 
   cmax: maximum open parenthesis -> Could be paired unbalanced '('
   cmin: minimum open parenthesis -> MUST be paired unbalanced '('
   Ex. '(' -> cmin = 1, cmax = 1
       '(*(' -> cmin = 1, cmax = 3
   The string is valid for 2 condition:
   1. cmax will never be negative 
   2. cmin is 0 at the end (No more ')' needed)

*/

/*
    public boolean checkValidString(String s) {
        int cmin = 0, cmax = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                cmax++;
                cmin++;
            } else if (c == ')') {
                cmax--;
                cmin = Math.max(cmin - 1, 0);
            } else {
                cmax++;
                cmin = Math.max(cmin - 1, 0);
            }
            if (cmax < 0) return false;
        }
        return cmin == 0;
    }
*/