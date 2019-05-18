class Solution {
    int sublen;
    int all;
    int wordslen;
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if (s.length() == 0 || words.length == 0 || s.length() < words.length * words[0].length()) return res;
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        wordslen = words.length;
        sublen = words[0].length();
        all = wordslen * sublen;
        for (int i = 0; i <= s.length() - all; ++i) {
            if (checkSub(s, i, words, map)) res.add(i);
        }        
        return res;
    }
    public boolean checkSub(String s, int index, String[] words, Map<String, Integer> map) {
        HashMap<String,Integer> set = new HashMap<String,Integer>(map);
        for (int i = 0; i < wordslen; ++i) {
            String target = s.substring(index + i * sublen, index + (i + 1) * sublen);
            if (!set.containsKey(target) || set.get(target) < 1) return false;
            else 
                set.put(target, set.get(target) - 1);
        }
        return true;        
    }
}