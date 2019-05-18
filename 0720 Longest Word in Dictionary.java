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

/* Using TrieTree
class Solution {
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        root.word = "-";
        for (String w : words)
            root.insert(w);
        return dfs(root, "");
    }
    
    String dfs(TrieNode node, String accum) {
        if (node == null || node.word.length() == 0)
            return accum;
        String res = "";
        if (!node.word.equals("-")) accum = node.word;
        for (TrieNode child : node.links) {
            String currRes = dfs(child, accum);
            if (currRes.length() > res.length() || (currRes.length() == res.length() && currRes.compareTo(res) < 0 ))
                res = currRes;
        }
        return res;
    }
    static class TrieNode {
        String word = "";
        TrieNode[] links = new TrieNode[26];
        
        void insert(String w) {
            char[] arr = w.toCharArray();
            TrieNode curr = this;
            for (int i = 0; i < arr.length; ++i) {
                int index = arr[i] - 'a';
                if (curr.links[index] == null)
                    curr.links[index] = new TrieNode();
                curr = curr.links[index];
            }
            curr.word = w;
        }
        
    }
    
}
*/