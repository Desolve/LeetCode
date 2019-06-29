class Solution {
    public String removeDuplicates(String S) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : S.toCharArray()) {
            if (!dq.isEmpty() && dq.peekLast() == c) {
                dq.pollLast();
            } else {
                dq.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : dq) { sb.append(c); }
        return sb.toString();
    }
}

/* faster solution by lee215

class Solution {
    public String removeDuplicates(String S) {
        char[] stack = S.toCharArray();
        int i = 0;
        for (int j = 0; j < S.length(); ++j)
            if (i > 0 && stack[i - 1] == S.charAt(j))
                --i;
            else
                stack[i++] = S.charAt(j);
        return new String(stack, 0, i);
    }
}

// beat 100% solution
class Solution {
    public String removeDuplicates(String S) {
        char[] sChars = S.toCharArray();
        int prevLength = -1, currentLength = S.length();
        if(S.length() < 2){
            return S;
        }
        while(prevLength != currentLength){
           prevLength = currentLength;
           currentLength = findDuplicates(sChars, prevLength);
        }
        return new String(sChars).substring(0, currentLength);      
    }
    int findDuplicates(char[] sChars, int length){
        int k = 0;
        char prev = '\0';
        for(int i=0;i<length;i++){
            if(prev != sChars[i]){
                sChars[k++] = sChars[i];
                prev = sChars[i];
            }
            else{
                k--;
                if(k>0){
                    prev = sChars[k-1];                   
                }
                else{
                    prev = '\0';
                    k = 0;
                }                
            }
        }
        return k;
    }
}
*/