/*
  A valid p will have the same count of '(' and ')'.
  Use a count to detect where a p ends, and only includes the inner elements.
*/
class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder s = new StringBuilder();
        int opened = 0;
        for (char c : S.toCharArray()) {
            if ( c == '(' && opened++ > 0 ) s.append(c);
            else if ( c == ')' && opened-- > 1 ) s.append(c);
        }
        return s.toString();
    }
}

/* 1ms solution: use two pointers and get the characters,
then copied to the front of the char array C.
It's faster since it does the combining at the end rather than append each time.

class Solution {
    public String removeOuterParentheses(String S) {
        if(S == null || S.length()==0) return S;
        char[] C = S.toCharArray();
        int level = 0;
        int slow=0, fast=0;
        for(int i=0;i<C.length;i++){
            if(C[i]=='('){
                if(level==0){
                    fast++;
                }else{
                    C[slow++] = C[fast++];
                }
                level++;
            }else{
                if(level==1){
                    fast++;
                }else{
                    C[slow++] = C[fast++];
                }
                level--;
            }
        }
        return new String(C,0,slow);
    }
}
*/