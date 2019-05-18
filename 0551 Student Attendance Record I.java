class Solution {
    public boolean checkRecord(String s) {
        char[] arr = s.toCharArray();
        int cntA = 0;
        int contL = 0;
        for (char ch : arr) {
            if (ch == 'A') {
                ++cntA;
                if (cntA > 1) return false;
                contL = 0;
            } else if (ch == 'L') {
                ++contL;
                if (contL > 2) return false;
            } else {
                contL = 0;
            }            
        }
        return true;
    }
}

/* One-line solution: (but slow)
class Solution {
    public boolean checkRecord(String s) {
        return !s.matches(".*A.*A.*") && !s.matches(".*LLL.*");
    }
}
*/

/* Fastest solution:
class Solution {
    public boolean checkRecord(String s) {
        return !s.contains("LLL") && (s.indexOf("A") == s.lastIndexOf("A"));
    }
}
*/