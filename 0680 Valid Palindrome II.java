class Solution {
    public boolean validPalindrome(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0, j = arr.length - 1; i < j; ++i, --j)
            if (arr[i] != arr[j]) return isp(arr, i + 1, j) || isp(arr, i, j - 1);
        return true;
    }

    private boolean isp(char[] arr, int l, int r) {
        for (; l < r; ++l, --r)
            if (arr[l] != arr[r]) return false;
        return true;
    }
}