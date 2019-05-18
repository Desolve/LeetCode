/*
925. Long Pressed Name
Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.

 

Example 1:

Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.
Example 2:

Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
Example 3:

Input: name = "leelee", typed = "lleeelee"
Output: true
Example 4:

Input: name = "laiden", typed = "laiden"
Output: true
Explanation: It's not necessary to long press any character.
 

Note:

name.length <= 1000
typed.length <= 1000
The characters of name and typed are lowercase letters.
*/

class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int nlen = name.length();
        int tlen = typed.length();
        if (nlen > tlen) return false;
        if (nlen == tlen) return name.equals(typed);
        if (name.equals("")) return false;
        int i = 0, j = 0, icnt = 0, jcnt = 0;
        while (i < nlen && j < tlen) {
            char ni = name.charAt(i);
            char nj = typed.charAt(j);
            if (ni == nj) {
                while (i < nlen && name.charAt(i) == nj) {++icnt; ++i;}
                while (j < tlen && typed.charAt(j) == ni) {++jcnt; ++j;}
                if (icnt > jcnt) return false;
                if (i == nlen && j == tlen) return true;
                if (i == nlen || j == tlen) return false;
                icnt = 0;
                jcnt = 0;
            } else {
                return false;
            }
        }
        return true;
    }
}