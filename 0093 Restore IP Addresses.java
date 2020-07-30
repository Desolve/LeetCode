class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<String>();
        checkIP(s, res, 0, 0, "");
        return res;
    }
    private void checkIP(String s, List<String> res, int i, int cnt, String cur) {
        if (s.length() - i < 4 - cnt) return;
        if (cnt == 3) {
            if (s.length() - i <= 3) {
                if (s.charAt(i) != '0' && Integer.parseInt(s.substring(i)) <= 255 || s.substring(i).equals("0")) {                    
                    cur += s.substring(i);
                    res.add(cur);                    
                }
            }
        } else {
            for (int j = 1; j <= 3 && i + j <= s.length(); ++j) {                
                if (s.charAt(i) != '0' && Integer.parseInt(s.substring(i, i + j)) <= 255 || s.substring(i, i + j).equals("0")) {
                    checkIP(s, res, i + j, cnt + 1, cur + s.substring(i, i + j) + ".");
                }
            }
        }
    }
}