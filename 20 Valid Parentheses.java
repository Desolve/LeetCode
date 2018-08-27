class Solution {
    public static boolean isValid(String s) {
        int len = s.length();
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < len; i++){
            if(st.isEmpty()){
                st.push(s.charAt(i));
            }else{
                char tmp = st.peek();
                char c = s.charAt(i);
                switch(tmp){
                    case '{':
                        if(c == '}') 
                            st.pop();
                        else
                            st.push(c);
                        break;
                    case '[':
                        if(c == ']') 
                            st.pop();
                        else
                            st.push(c);                        
                        break;
                    case '(':  
                        if(c == ')') 
                            st.pop();
                        else
                            st.push(c);
                        break;                        
                }
            }                
        }
        if(st.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}