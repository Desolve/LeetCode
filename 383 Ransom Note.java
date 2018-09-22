class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> sum = new HashMap<Character, Integer>();
        for (char c: magazine.toCharArray()) sum.put(c, sum.getOrDefault(c, 0)+1);
        for (char c: ransomNote.toCharArray()) {
            int cnt = sum.getOrDefault(c, 0);
            if (cnt < 1) return false;
            sum.put(c, cnt-1);
        }
        return true;
    }
}

/* Faster solution using array
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] table = new int[26];
        for (char c : magazine.toCharArray())   table[c - 'a']++;
        for (char c : ransomNote.toCharArray())
            if (--table[c - 'a'] < 0) return false;
        return true;
    }
}
*/