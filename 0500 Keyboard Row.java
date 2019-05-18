/* 
檢查第一個字元在哪一列，再依序確認是否全部都在同一列。
這題沒有限制CapsLock和Shift的部分，否則如"QwerTY"這樣子的字串理應不能通過。
found也可以直接用type = -1來處理檢查，
但速度會比使用boolean値檢查慢很多。
*/
class Solution {
    public String[] findWords(String[] words) {
        List<String> lst = new ArrayList<String>();
        final String[] set = {"QWERTYUIOPqwertyuiop", "ASDFGHJKLasdfghjkl", "ZXCVBNMzxcvbnm"};
        for (String word: words) {
            char ch = word.charAt(0);
            int type = -1;
            if (set[0].indexOf(ch) != -1) type = 0;
            else if (set[1].indexOf(ch) != -1) type = 1;
            else type = 2;
            boolean found = true;
            for (char c: word.toCharArray()) {
                if (set[type].indexOf(c) == -1) {
                    found = false;
                    break;
                }
            }
            if (found) lst.add(word);
        }
        String[] result = new String[lst.size()];
        lst.toArray(result);
        return result;
    }
}

/* One-line solution (但效率很低落)
class Solution {
    public String[] findWords(String[] words) {
        return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
    }
}
*/