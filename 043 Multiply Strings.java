class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int len1 = num1.length();
        int len2 = num2.length();
        int[] res = new int[len1 + len2];
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        for (int i = len1 - 1; i >= 0; --i) {
            char c1 = arr1[i];
            for (int j = len2 - 1; j >= 0; --j) {
                char c2 = arr2[j];
                int mul = (c1 - '0') * (c2 - '0');
                int d = len1 + len2 - 2 - i - j;
                res[d] += mul;
                res[d + 1] += res[d] / 10;
                res[d] %= 10;
            }
        }
        int last = len1 + len2 - 1;
        if (res[last] == 0) last--;
        StringBuilder st = new StringBuilder();
        while (last >= 0) {
            st.append(res[last--]);
        }
        return st.toString();
    }
}