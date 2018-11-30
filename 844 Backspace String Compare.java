class Solution {
    public boolean backspaceCompare(String S, String T) {
        List<Character> s = new ArrayList<>();
        List<Character> t = new ArrayList<>();
        type(s, S);
        type(t, T);
        if (s.size() != t.size()) 
            return false;
        else {
            for (int i = 0; i < s.size(); ++i) {
                if (s.get(i) != t.get(i)) 
                    return false;
            }                
        }
        return true;            
    }
    
    public void type(List l, String str) {
        for (char ch : str.toCharArray()) {
            if (ch == '#') {
                if (!l.isEmpty()) 
                    l.remove(l.size() - 1);
            } else {
                l.add(ch);
            }
        }
    }
}

/* StringBuilder solution is a little bit faster (from kandulab)
class Solution {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder newS = new StringBuilder();
        StringBuilder newT = new StringBuilder();

        int newSCount = 0;
        int newTCount = 0; 


        for(int i=S.length()-1;i>=0;--i)
        {

            if(S.charAt(i) == '#')
                newSCount++;
            else if(S.charAt(i)!='#' && newSCount > 0)
                newSCount--;
            else if(S.charAt(i)!='#')
                newS.append(S.charAt(i));

        }

        for(int i=T.length()-1;i>=0;--i)
        {
            if(T.charAt(i) == '#')
                newTCount++;
            else if(T.charAt(i)!='#' && newTCount > 0){
                newTCount--;
            }else if(T.charAt(i)!='#')
                newT.append(T.charAt(i));
        }

        return newS.toString().equals(newT.toString());

    }
}
*/

/* Fastest but limited using the limit that length is at most 200 (from BobLikeJava)
class Solution {
    public boolean backspaceCompare(String S, String T) {
        char[] s = new char[200];
        char[] t = new char[200];
        
        int i = 0, j = 0;
        for (char c : S.toCharArray()) {
            if (c == '#') i = i == 0 ? 0 : i - 1;
            else s[i++] = c;
        }
        for (char c : T.toCharArray()) {
            if (c == '#') j = j == 0 ? 0 : j - 1;
            else t[j++] = c;
        }
        
        if (i != j) return false;
        for (int k = 0; k < i; k++) {
            if (s[k] != t[k]) return false;
        }
        return true;
    }
}
*/