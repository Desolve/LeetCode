class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<Character, String>();
        int clen = pattern.length();
        String[] s = str.split(" ");
        if (clen != s.length) return false;
                
        for (int i = 0; i < clen; i++) {
            char c = pattern.charAt(i);
            if (!map.containsKey(c))
                if (!map.containsValue(s[i]))
                    map.put(c, s[i]);
                else
                    return false;
            else
                if (!map.get(c).equals(s[i]))
                    return false;
        }
        return true;
        
    }
}