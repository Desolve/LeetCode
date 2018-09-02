class Solution {
    public String countAndSay(int n) {
        String str = "1";
        if (n == 1) return str;
        while (n-- > 1) {
            str = gen(str);
        }
        return str;
    }

    private String gen(String str) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < str.length(); ) {
            int cnt = 0;
            char cur = str.charAt(i);
            while (i < str.length() && cur == str.charAt(i)) {
                i++;
                cnt++;
            }
            s.append(cnt).append(cur);
        }
        return s.toString();
    }
}