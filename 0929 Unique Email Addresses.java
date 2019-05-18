class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<String>();
        for (String email : emails) {
            String[] sep = email.split("@");
            String local = filter(sep[0]);
            set.add(local + '@' + sep[1]);
        }
        return set.size();
    }
    public String filter(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '+') break;
            if (ch == '.') continue;
            sb.append(ch);
        }
        return new String(sb);
    }
}