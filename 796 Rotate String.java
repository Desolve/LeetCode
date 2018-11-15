class Solution {
    public boolean rotateString(String A, String B) {
        return (A.length() == B.length()) && (A + A).contains(B);
    }
}
/* Faster solution without built-in function
class Solution {
    public boolean rotateString(String A, String B) {
        if(A == null || B == null || A.length() != B.length())
            return false;
        if(A.length() == 0)
            return true;
        
        char start = A.charAt(0);
        
        for(int i = 0; i < B.length(); i++) { 
				
            int j = i;
            while(j < B.length() && B.charAt(j) != start)
                j++;
            
            if(j >= B.length()) 
                return false;
            
            for(int n = 0; n < B.length(); n++) {
                if(A.charAt(n) != B.charAt((n + j) % B.length()))
                    break;
                if(n == B.length() - 1)
                    return true;
            }
            
           i = j;
        }
        
        return false;
    }
}
*/