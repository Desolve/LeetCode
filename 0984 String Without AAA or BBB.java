class Solution {
    public String strWithout3a3b(int A, int B) {
        StringBuilder st = new StringBuilder();
        int diff = A - B;
        if (diff == 0) {
            while (A-- > 0) st.append("ab");
        } else if (diff > 0) {
            while (diff-- > 0 && B > 0) { st.append("aab"); B--; A-=2; }
            while (B-- > 0) { st.append("ab"); A--; }
            while (A-- > 0) st.append("a");
        } else {
            while (diff++ < 0 && A > 0) { st.append("bba"); A--; B-=2;}
            while (A-- > 0) { st.append("ba"); B--; }
            while (B-- > 0) st.append("b");
        }
        
        return st.toString();
    }
}

/* Another solution from rock
// If current result ends with aa, next char is b; if ends with bb, next char must be a.
// Other cases, if A > B, next char is a; otherwise, next char is b.

class Solution {
    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();
        while (A + B > 0) {
            String s = sb.toString();
            if (s.endsWith("aa")) {
                sb.append("b");
                --B;       
            }else if (s.endsWith("bb")){
                sb.append("a");
                --A;
            }else if (A > B) {
                sb.append("a");
                --A;
            }else {
                sb.append("b");
                --B;
            }
        }
        return sb.toString();
    }
}
*/