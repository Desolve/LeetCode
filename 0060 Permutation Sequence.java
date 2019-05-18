class Solution {
    public String getPermutation(int n, int k) {
        if (n == 1) return "1";
        int[] fact = new int[n];
        boolean[] used = new boolean[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) fact[i] = fact[i-1] * i;
        StringBuilder st = new StringBuilder();
        return getPermutation(n, k, 1, fact, used, st);
    }
    public String getPermutation(int n, int k, int d, int[] fact, boolean[] used, StringBuilder st) {        
        if (n == d || k == 1) { // The remain part is placed by the order of numbers
            for (int i = 1; i <= n; i++) {
                if (!used[i-1]) {
                    st.append(i);
                }
            }
            return st.toString();
        } else {
            //System.out.printf("n, k, d, fact[n - d] = %d, %d, %d, %d\n", n, k, d, fact[n-d]);
            if (k < fact[n - d]) { // Pick the smallest num
                int pick = 0;
                while (used[pick]) pick++;
                used[pick] = true;
                st.append(pick + 1);
                return getPermutation(n, k, d + 1, fact, used, st);
            } else if (k > fact[n - d]) { // Pick the order-th num
                int remain = k % fact[n - d];
                int order = k / fact[n - d] + ((remain > 0)? 1 : 0);
                //System.out.printf("remain, order = %d, %d\n", remain, order);
                for (int i = 1, cnt = 0; i <= n; i++) {
                    if (!used[i - 1] && (++cnt == order)) {
                        used[i - 1] = true;
                        st.append(i);
                        break;
                    }
                }
                if (remain == 0) { // The remain part is in decreasing order
                    for (int i = n; i >= 1 ; i--) {
                        if (!used[i-1])
                            st.append(i);
                    }
                    return st.toString();
                } else 
                    return getPermutation(n, remain, d + 1, fact, used, st);                
            } else { // Just fit (n-d)!, pick the smallest + decreasing order
                for (int i = 1; i <= n; i++) {
                    if (!used[i-1]) {
                        used[i-1] = true;
                        st.append(i);
                        break;
                    }
                }
                for (int i = n; i >= 1; i--) {
                    if (!used[i-1])
                        st.append(i);
                }
                return st.toString();
            }
        }
    }
}