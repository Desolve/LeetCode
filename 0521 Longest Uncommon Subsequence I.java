// 題目定義上最長的subsequence就是a或b， 所以只要比長度就好。
class Solution {
    public int findLUSlength(String a, String b) {
        return a.equals(b)? -1: Math.max(a.length(), b.length());
    }
}