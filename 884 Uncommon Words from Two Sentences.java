class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Integer> map = new HashMap<>();
        mapping(A, map);
        mapping(B, map);
        List<String> res = new LinkedList<>();
        for (String key : map.keySet()) {
            if (map.get(key) == 1) res.add(key);
        }
        return res.toArray(new String[0]);
    }
    public void mapping(String s, HashMap map) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') i++;
        if (i == s.length()) return;
        StringBuilder st = new StringBuilder();
        st.append(s.charAt(i++));
        for (; i < s.length(); i++) {
            if (s.charAt(i) != ' ') st.append(s.charAt(i));
            else {
                map.put(st.toString(), 1 + (int)map.getOrDefault(st.toString(), 0));
                while (i < s.length() && s.charAt(i) == ' ') i++;
                if (i == s.length()) return;
                st = new StringBuilder();
                st.append(s.charAt(i));
            }
        }
        if (s.charAt(i-1) != ' ')
            map.put(st.toString(), 1 + (int)map.getOrDefault(st.toString(), 0));
    }
}

/* Using split function
class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> count = new HashMap();
        for (String word: A.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);
        for (String word: B.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);

        List<String> ans = new LinkedList();
        for (String word: count.keySet())
            if (count.get(word) == 1)
                ans.add(word);

        return ans.toArray(new String[ans.size()]);
    }
}
*/