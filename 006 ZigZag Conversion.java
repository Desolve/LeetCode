class Solution {
    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) return s;
        ArrayList<Character>[] res = (ArrayList<Character>[]) new ArrayList[numRows];
        int cycle = numRows * 2 - 2;
        for (int i = 0; i < s.length(); ++i) {
            int j = i % cycle;
            if (j >= numRows) {
                j = 2 * numRows - j - 2;
            }
            if (res[j] == null) res[j] = new ArrayList<>();
            res[j].add(s.charAt(i));
        }
        StringBuilder st = new StringBuilder();
        for (ArrayList a : res) {
            for (int i = 0; i < a.size(); ++i)
                st.append(a.get(i));
        }
        return st.toString();
    }
}

/* No arraylist, use step to scan row by row instead. (from zxqhoho)
class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 0)
            return "";
        if (s.length()<numRows||numRows==1)
            return s;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int step = 0;
            boolean reverse = false;
            while (i + step < s.length()) {
                builder.append(s.charAt(i + step));
                if (i == 0 || i == numRows - 1) {
                    step += 2 * (numRows - 1);
                } else {
                    step += reverse ?  2 * i:2 * (numRows - 1 - i);
                    reverse = !reverse;
                }
            }
        }
        return builder.toString();
    }
}
*/