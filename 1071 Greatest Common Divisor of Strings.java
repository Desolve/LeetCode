class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int l1 = str1.length(), l2 = str2.length();
        if (l1 < l2) return gcdOfStrings(str2, str1);
        if (str1.equals(str2)) return str1;
        if (str1.startsWith(str2)) return gcdOfStrings(str1.substring(l2), str2);
        else return "";
    }
}