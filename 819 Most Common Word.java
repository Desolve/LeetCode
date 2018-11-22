// Use a Trie to deal with words.
class Solution {
    public String res;
    public int maxcnt;
    public String mostCommonWord(String paragraph, String[] banned) {
        TrieNode root = new TrieNode();
        StringBuilder st = new StringBuilder();
        res = "";
        maxcnt = 0;
        boolean isString = false;
        for (char ch : paragraph.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                st.append(ch);
                isString = true;
            } else if (ch >= 'A' && ch <= 'Z') {
                st.append((char)(ch + 'a' - 'A'));
                isString = true;
            } else {
                if (isString) {
                    root.insert(st.toString());
                    st = new StringBuilder();
                    isString = false;
                } 
            }
        }
        if (isString) root.insert(st.toString());        
        for (String s : banned) root.ban(s);
        root.findMax(root);
        return res;
    }
    class TrieNode {
        String word = "";
        int cnt = 0;
        TrieNode[] links = new TrieNode[26];
        
        void insert(String s) {
            TrieNode curr = this;
            char[] chs = s.toCharArray();
            for (int i = 0; i < chs.length; ++i) {
                int index = chs[i] - 'a';
                if (curr.links[index] == null) {
                    curr.links[index] = new TrieNode();
                    curr.links[index].word = curr.word + chs[i];
                }
                curr = curr.links[index];
            }
            curr.cnt += 1;
        }
        void ban(String s) {
            char[] chs = s.toCharArray();
            TrieNode curr = this;
            for (int i = 0; i < chs.length; ++i) {
                int index = chs[i] - 'a';
                if (curr.links[index] == null) return;
                curr = curr.links[index];
            }
            curr.cnt = 0;
        }
        void findMax(TrieNode curr) {
            if (curr == null) return;
            if (curr.cnt > maxcnt) {
                res = curr.word;
                maxcnt = curr.cnt;
            }
            for (int i = 0; i < curr.links.length; ++i) {
                findMax(curr.links[i]);
            }
        }
        
        
    }
}
/*
https://en.wikipedia.org/wiki/Trie
We'll use a Trie to solve this problem.
Every TrieNode has 26 links, representing 26 lower-case letters.
The root represents empty string, and each link points to the first character of a string.
We use word to save the string that the node represents, and use cnt to count on number of times we meet the string.

During "mostCommonWord", we could use StringBuilder to append the valid characters(and turn them to all lowercase),
while we meet any non-letter character, insert the string to the Trie.

The main part of TrieNode functions are describes below:

1. insert:
Take a char from string letter by letter, and go through the links.
If curr.links[index] == null, that means we haven't had a path pass by,
new the TrieNode and set the "word".
At the last of the TrieNode, we need to increase the cnt.
2. ban:
Ban out the string means that we could set the cnt of string to zero.
Notice that if we meet null links, just return since the string is not exist in the paragraph.
3. findMax:
Go through all TrieNode and find the largest cnt and its word.

The following is for 中文使用者。
這個解法是使用字典樹來解，樹根代表空字串，每個字串都會有26個link，代表26個小寫字母。
我們在每個TrieNode中存放word(走到這實際的字串)和cnt(記錄這個字串有幾個)。
在mostCommonWord中，使用StringBuilder每次將合法的字元(大小寫字母)加入(並轉成小寫)，
在遇到非字母的字元的時候，就把目前的這個字串塞進字典樹裡。

TrieNode這邊有三個functions:

1. insert:
透過每個字母沿links的路徑走，如果curr.links[index] == null則表示前面還沒走過，
要自行new出來，並設定其word變數。
在走到底的時候我們要將cnt數加1。
2. ban:
只要將該string的cnt設成零即可。
如果在走的路徑途中遇到null，表示段落裡不存在這個string，直接return即可。
3. findMax:
遍歷所有TrieNode並找到最大的cnt及對應的word。
*/

/*
// Easy but slow solution
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("[ !?',;.]+");
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        for(String word : banned) if(map.containsKey(word)) map.remove(word);
        String res = null;
        for(String word : map.keySet())
            if(res == null || map.get(word) > map.get(res))
                res = word;
        return res;
    }
}

*/