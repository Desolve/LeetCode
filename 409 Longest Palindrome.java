class Solution {
    public int longestPalindrome(String s) {
        int len = 0;
        boolean ifsingle = false;
        int[] cnt = new int[128];
        char[] arr = s.toCharArray();
        for (char ch: arr) {
            cnt[ch]++;
        }
        // Paired characters can be all included. For ASCII Code, A-Z: 65~90, a-z:97~122
        for (int i = 65; i <= 90; i++) {
            len += (cnt[i] / 2) * 2;
        }
        for (int i = 97; i <= 122; i++) {
            len += (cnt[i] / 2) * 2;
        }
        // Single character may exist at the middle
        for (int i = 0; i <= 122; i++) {
            if(cnt[i] % 2 == 1){
                len++;
                break;
            }
        }
        return len;
    }
}

/* Another solution:
class Solution {
    public int longestPalindrome(String s) {
        boolean[] map = new boolean[128];
        int len = 0;
        for (char c : s.toCharArray()) {
            map[c] = !map[c];         // flip on each occurrence, false when seen n*2 times
            if (!map[c]) len+=2;
        }
        if (len < s.length()) len++; // if more than len, atleast one single is present
        return len;
    }
}
*/