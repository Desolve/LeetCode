class Solution {
    public static int row = 0;
    public static int col = 0;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        row = board.length;
        col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        Arrays.sort(words);
        String prev = "";
        for (String word : words) {
            if (!word.equals(prev)) {
                findWord(res, board, word, visited);
                prev = word;
            }
        }
        return res;
    }
    public void findWord(List res, char[][] board, String word, boolean[][] visited) {        
        for (int i = 0; i < row ; i++) 
            for (int j = 0; j < col; j++) 
                if (dfs(res, board, word, visited, i, j, 0)) return;
    }
    public boolean dfs(List res, char[][] board, String word, boolean[][] visited, int i, int j, int prev) {
        if (visited[i][j] || board[i][j] != word.charAt(prev)) return false;
        if (word.length() == prev + 1) {
            res.add(word);
            return true;
        }
        visited[i][j] = true;
        if (i + 1 < row) {
            if (dfs(res, board, word, visited, i + 1, j, prev + 1)) {
                visited[i][j] = false;
                return true;
            }
        }
        if (i - 1 >= 0) {
            if (dfs(res, board, word, visited, i - 1, j, prev + 1)) {
                visited[i][j] = false;
                return true;
            }
        }
        if (j + 1 < col) {
            if (dfs(res, board, word, visited, i, j + 1, prev + 1)) {
                visited[i][j] = false;
                return true;
            }
        }
        if (j - 1 >= 0) {
            if (dfs(res, board, word, visited, i, j - 1, prev + 1)) {
                visited[i][j] = false;
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}

/* 14ms solution using Trie (inspired from johnson9432 and change a little)
class Solution {
    class Trie {
        Trie[] next = new Trie[26];
        String word;
        Trie(){}
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0) return res;
        int row = board.length;
        int col = board[0].length;
        Trie root = buildTrie(words);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int ch = board[i][j] - 'a';
                if (root.next[ch] == null) continue;
                Trie r = root;
                boolean[][] visited = new boolean[row][col];
                dfs(r, i, j, res, board, visited);
            }
        }
        return res;
    }
    private Trie buildTrie(String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            Trie r = root;
            for (char c : word.toCharArray()) {
                int ch = c - 'a';
                if (r.next[ch] == null) {
                    r.next[ch] = new Trie();
                }
                r = r.next[ch];
            }
            r.word = word;
        }
        return root;
    }
    
    public void dfs(Trie r, int i, int j, List<String> res, char[][] board, boolean[][] visited) {
        if (r.next[board[i][j] - 'a'] == null) return;
        if (r.next[board[i][j] - 'a'].word != null) {
            res.add(r.next[board[i][j] - 'a'].word);
            r.next[board[i][j] - 'a'].word = null; // prevent duplicate word
        }
        visited[i][j] = true;
        if (i + 1 < board.length    && !visited[i + 1][j]) dfs(r.next[board[i][j] - 'a'], i + 1, j, res, board, visited);
        if (i - 1 >= 0              && !visited[i - 1][j]) dfs(r.next[board[i][j] - 'a'], i - 1, j, res, board, visited);
        if (j + 1 < board[0].length && !visited[i][j + 1]) dfs(r.next[board[i][j] - 'a'], i, j + 1, res, board, visited);
        if (j - 1 >= 0              && !visited[i][j - 1]) dfs(r.next[board[i][j] - 'a'], i, j - 1, res, board, visited);
        visited[i][j] = false;
    }
}
*/

/* slightly faster solution
class Solution {
    public static int row = 0;
    public static int col = 0;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        row = board.length;
        col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        boolean found;
        Set<String> wordset = new HashSet<>();
        for (int c = 0; c < words.length; c++) {
            String word = words[c];
            if (wordset.contains(word)) 
                continue;
            else
                wordset.add(word);
            found = false;
            for (int i = 0; i < row && !found; i++) {
                for (int j = 0; j < col && !found; j++) {
                    if (dfs(res, board, word, visited, i, j, 0)) {
                        found = true; break;
                    }                    
                }
            }
        }
        return res;
    }
    public boolean dfs(List res, char[][] board, String word, boolean[][] visited, int i, int j, int prev) {
        if (visited[i][j] || board[i][j] != word.charAt(prev)) return false;
        if (word.length() == prev + 1) {
            res.add(word);
            return true;
        }
        visited[i][j] = true;
        if (i + 1 < row) {
            if (dfs(res, board, word, visited, i + 1, j, prev + 1)) {
                visited[i][j] = false;
                return true;
            }
        }
        if (i - 1 >= 0) {
            if (dfs(res, board, word, visited, i - 1, j, prev + 1)) {
                visited[i][j] = false;
                return true;
            }
        }
        if (j + 1 < col) {
            if (dfs(res, board, word, visited, i, j + 1, prev + 1)) {
                visited[i][j] = false;
                return true;
            }
        }
        if (j - 1 >= 0) {
            if (dfs(res, board, word, visited, i, j - 1, prev + 1)) {
                visited[i][j] = false;
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}
*/