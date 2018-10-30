class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> st = new HashSet<String>();
        String res = "";
        for (String w : words) {
            if (w.length() == 1 || st.contains(w.substring(0, w.length() - 1))) {
                res = w.length() > res.length() ? w : res;
                st.add(w);
            }
        }
        return res;
    }
}