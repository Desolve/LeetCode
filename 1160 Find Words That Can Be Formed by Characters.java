class Solution {
    public int countCharacters(String[] words, String chars) {
        int res = 0;
        int[] dic = new int[26];
        for (char c : chars.toCharArray()) {
            ++dic[c - 'a'];
        }        
        for (String word : words) {
            res += check(word, dic);
        }
        return res;
    }
    
    public int check(String word, int[] dic) {
        int[] count = new int[26];        
        for (char c : word.toCharArray()) {
            ++count[c - 'a'];
            if (count[c - 'a'] > dic[c - 'a'])
                return 0;
        }
        
        return word.length();
    }
}