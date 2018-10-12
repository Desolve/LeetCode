class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) return true;
        char first = word.charAt(0);
        if (first >= 'a') { // case 2
            for (int i = 1; i < word.length(); ++i) {
                char ch = word.charAt(i);
                if (ch < 'a')
                    return false;
            }
            return true;
        } else {
            char second = word.charAt(1);
            if (second < 'a') { // case 1
                for (int i = 2; i < word.length(); ++i) {
                    char ch = word.charAt(i);
                    if (ch >= 'a')
                        return false;
                }
                return true;
            } else { // case 3
                for (int i = 2; i < word.length(); ++i) {
                    char ch = word.charAt(i);
                    if (ch < 'a')
                        return false;
                }
                return true;
            }
            
        }
    }
}

/* Much faster solution:
class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() < 2) return true;
        if (word.toUpperCase().equals(word)) return true;
        if (word.substring(1).toLowerCase().equals(word.substring(1))) return true;
        return false;
    }
}
*/