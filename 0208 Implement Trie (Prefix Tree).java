class TrieNode {
    public boolean isWord;
    public TrieNode[] next = new TrieNode[26];
    public TrieNode() {}
}

class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode ite = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (ite.next[c - 'a'] == null) {
                ite.next[c - 'a'] = new TrieNode();
            }
            ite = ite.next[c - 'a'];
        }
        ite.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode ite = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (ite.next[c - 'a'] == null) {
                return false;
            }
            ite = ite.next[c - 'a'];
        }
        return ite.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode ite = root;
        for (int i = 0; i < prefix.length(); ++i) {
            char c = prefix.charAt(i);
            if (ite.next[c - 'a'] == null) {
                return false;
            }
            ite = ite.next[c - 'a'];
        }
        return true;
    }
}