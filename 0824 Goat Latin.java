class Solution {
    public String toGoatLatin(String S) {
        String vowel = "aeiouAEIOU";
        String[] words = S.split(" ");
        StringBuilder res = new StringBuilder();
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            st.append("a");
            char firstch = words[i].charAt(0);
            if (vowel.indexOf(firstch) != -1) {
                res.append(words[i] + "ma" + st);
            } else {
                res.append(words[i].substring(1) + firstch + "ma" + st);
            }
            if (i != words.length - 1) res.append(" ");
        }
        return res.toString();
    }
}