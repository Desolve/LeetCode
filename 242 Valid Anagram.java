class Solution {
    public boolean isAnagram(String s, String t) {
        int[] cnt = new int[26];
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
            cnt[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++)
            if (cnt[i] != 0) 
                return false;
        return true;
    }
}

/* 若拆開來跑，在第二段時去一個一個減次數，只要判定有任一個次數會減到小於0就可以return false了!這個方法會快很多。
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) return false;
        int[] count = new int[26];
        int len = t.length();
        for(int i = 0; i < len; i++) {
            count[t.charAt(i) - 'a']++;
        }
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(count[c - 'a'] > 0) {
                count[c - 'a']--;
            } else {
                return false;
            }
        }
        return true;
    }
}
*/