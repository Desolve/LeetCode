class Solution {
    public String reverseString(String s) {
        int i = 0, j = s.length() - 1;
        char[] ch = s.toCharArray();
        while(i < j) {
            char tmp = ch[i];
            ch[i] = ch[j];
            ch[j] = tmp;
            i++; j--;
        }
        return new String(ch);
    }
}

/* Build-in functions:
class Solution {
    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
*/