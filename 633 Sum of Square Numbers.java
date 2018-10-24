class Solution {
    public boolean judgeSquareSum(int c) {
        HashSet<Integer> set = new HashSet<Integer>();
        int i = 0;
        int j = (int) Math.sqrt(c);
        while (i <= j) {
            if (i * i + j * j < c) i++;
            else if (i * i + j * j > c) j--;
            else return true;
        }
        return false;
    }
}