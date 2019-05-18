class Solution {
    public boolean isPalindrome(String s) {
        if(s == null) return false;
        if(s.isEmpty()) return true;
        int start = 0, end = s.length()-1;
        while(start < end) {
            char ch1 = s.charAt(start);
            if(!Character.isLetter(ch1) && !Character.isDigit(ch1)) {
                start++; continue;
            }
            char ch2 = s.charAt(end);
            if(!Character.isLetter(ch2) && !Character.isDigit(ch2)) {
                end--; continue;
            }
            ch1 = Character.toLowerCase(ch1);
            ch2 = Character.toLowerCase(ch2);
            if(ch1 == ch2) {
                start++; end--; continue;
            } else {
                return false;
            }
        }
        return true;
    }
}

/* Python 3 Solution 
def isPalindrome(self, s):
    """
    :type s: str
    :rtype: bool
    """
    l, r = 0, len(s)-1
    while l < r:
        if not s[l].isalnum():
            l += 1
            continue
        if not s[r].isalnum():
            r -= 1
            continue
        if s[l].lower() != s[r].lower():
            return False
        l += 1
        r -= 1
    return True
*/