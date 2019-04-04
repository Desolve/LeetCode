class Solution {
    public List<String> commonChars(String[] A) {
        int[] dict = new int[26];
        List<String> res = new ArrayList<String>();
        for (char ch: A[0].toCharArray()) 
            ++dict[ch - 'a'];
        
        for (int i = 1; i < A.length; ++i) {
            int[] next = new int[26];
            
            for (char ch: A[i].toCharArray()) 
                ++next[ch - 'a'];
            
            for (int j = 0; j < 26; ++j) 
                if (dict[j] > next[j]) 
                    dict[j] = next[j];
        }
        
        for (int i = 0; i < 26; ++i) {
            while (dict[i]-- > 0) res.add("" + (char)('a' + i));
        }
        
        return res;
    }
}