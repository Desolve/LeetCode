class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() < 2) return true;
        Map<Character, Character> cMap = new HashMap<Character, Character>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);            
            if (!cMap.containsKey(cs)) {
                if (cMap.containsValue(ct))
                    return false;
                cMap.put(cs, ct);
            } else if (cMap.get(cs) != ct)
                return false;
        }
        return true;
    }
}

/* Another solution: 
The lastest character mapping will be set to i+1.
If you see some character mapping is NOT the same this time,
it means that a different mapping occurs, return false then.
public class Solution {
    public boolean isIsomorphic(String s1, String s2) {
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
        }
        return true;
    }
}*/

/* A faster solution:
Use two char array to build a HashMap.

public class Solution {
    public boolean isIsomorphic(String sString, String tString) {
        char[] s = sString.toCharArray();
        char[] t = tString.toCharArray();

        int length = s.length;
        if(length != t.length) return false;

        char[] sm = new char[256];
        char[] tm = new char[256];

        for(int i=0; i<length; i++){
            char sc = s[i];
            char tc = t[i];
            if(sm[sc] == 0 && tm[tc] == 0){
                sm[sc] = tc;
                tm[tc] = sc;
            }else{
                if(sm[sc] != tc || tm[tc] != sc){
                    return false;
                }
            }
        }
        return true;
    }
}
*/