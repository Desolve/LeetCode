// Although we could use 2 to 9 for String array for less memory space of combos(then you need to use combos[num - '2'],
// It faster using 0 to 9 (2 ms vs 3 ms)
class Solution {
    public static final String[] combos = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits.length() == 0) return res;
        helper(res, "", digits, 0);
        return res;
    }
    public void helper(List<String> res, String now, String digits, int len) {
        if (len == digits.length()) {
            res.add(now);
            return;
        }
        int num = digits.charAt(len);
        for (int i = 0; i < combos[num - '0'].length(); ++i) {
            String next = now + combos[num - '0'].charAt(i);            
            helper(res, next, digits, len + 1);
        }
    }
}