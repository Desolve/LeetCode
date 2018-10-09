class Solution {
    public String licenseKeyFormatting(String S, int K) {
        int chCnt = 0, len = S.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char ch = S.charAt(i);
            if (ch != '-') {
                chCnt++;
                if (ch >= 'a' && ch <= 'z') {
                    sb.append((char)(ch - 'a' + 'A'));
                } else {
                    sb.append(ch);
                }
            }
        }
        int remain = chCnt % K;
        int dashCnt = chCnt / K + (remain == 0? -1 : 0);
        if (remain == 0) remain += K;
        for (int i = remain; dashCnt > 0; i += K, dashCnt--) {
            sb.insert(i++, '-');
        }
        return sb.toString();
    }
}

/* Faster Solution:
class Solution {
    public String licenseKeyFormatting(String S, int K) {
        if (S == null || S.length() == 0) return "";
        String[] ss = S.split("-");
        StringBuilder sb = new StringBuilder();
        for (String s : ss) sb.append(s);
        String noDashS = sb.toString();
        sb = new StringBuilder();
        int firstK = noDashS.length() % K;
        if (firstK == 0) firstK = K;
        for (int i = 0; i < noDashS.length();) {
            if (i == 0) {
                if (i + firstK < noDashS.length()) sb.append(noDashS.substring(i, i + firstK));
                else sb.append(noDashS.substring(i, noDashS.length()));
                i += firstK;
                continue;
            } else if (i + K < noDashS.length()) sb.append("-" + noDashS.substring(i, i + K));
            else sb.append("-" + noDashS.substring(i, noDashS.length()));
            i += K;
        }
        return sb.toString().toUpperCase();
    }
}

*/