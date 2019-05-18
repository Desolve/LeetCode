class Solution {
    public String reverseStr(String s, int k) {
        int len = s.length();
        int remain = len % (2 * k);
        int pack = len / (2 * k);
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < pack; ++i) {            
            int start = i * 2 * k;
            int end = (i * 2 + 1) * k;
            st.append(getPart(s, start, end));
            st.append(s.substring(end, end+k));
        }
        if (remain > 0) {
            int start = pack * 2 * k;
            int end;
            if (remain >= k) {
                end = start + k;
                st.append(getPart(s, start, end));
                if (remain > k)
                    st.append(s.substring(end, start + remain));
            } else {
                end = start + remain;
                st.append(getPart(s, start, end));
            }
        }
        return st.toString();
    }
    public StringBuilder getPart(String s, int start, int end) {
        StringBuilder st = new StringBuilder();
        for (int i = end - 1; i >= start; --i) st.append(s.charAt(i));
        return st;
    }
}
/* Faster solution:
class Solution {
    public String reverseStr(String s, int k) {
        char[] ca = s.toCharArray();
        for (int left = 0; left < ca.length; left += 2 * k) {
            for (int i = left, j = Math.min(left + k - 1, ca.length - 1); i < j; i++, j--) {
                char tmp = ca[i];
                ca[i] = ca[j];
                ca[j] = tmp;
            }
        }
        return new String(ca);
    }
}
*/