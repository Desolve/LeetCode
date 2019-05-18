class Solution {
    public int repeatedStringMatch(String A, String B) {
        int cnt = 1;
        StringBuilder sb = new StringBuilder(A);
        while (sb.length() < B.length()) {
            sb.append(A);
            ++cnt;
        }
        if (sb.toString().contains(B)) return cnt;
        if (sb.append(A).toString().contains(B)) return ++cnt;
        return -1;
    }
}