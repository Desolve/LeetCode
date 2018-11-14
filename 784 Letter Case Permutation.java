class Solution {
    public List<String> letterCasePermutation(String S) {
        if (S == null) return new LinkedList<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);
        
        for (int i = 0; i < S.length(); ++i) {
            if (Character.isDigit(S.charAt(i))) continue;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                char[] chr = queue.poll().toCharArray();
                chr[i] = Character.toUpperCase(chr[i]);
                queue.offer(String.valueOf(chr));
                
                chr[i] = Character.toLowerCase(chr[i]);
                queue.offer(String.valueOf(chr));
            }
        }
        
        return new LinkedList<>(queue);
    }
}

/* DFS solution
class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        char[] a = S.toLowerCase().toCharArray();
        helper(a, 0, res);
        return res;
    }
    
    void helper(char[] a, int pos, List<String> res){
        if(pos==a.length){
            res.add(new String(a));
            return;
        }
        
        helper(a, pos+1, res);
        if(Character.isLetter(a[pos])) {
            a[pos] = Character.toUpperCase(a[pos]);
            helper(a, pos+1, res);
            a[pos] = Character.toLowerCase(a[pos]);
        }
    }
}

*/