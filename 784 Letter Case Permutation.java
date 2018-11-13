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