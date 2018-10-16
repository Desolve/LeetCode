class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; ++i) {
            int start, end;
            while (i < arr.length && arr[i] == ' ') ++i; // 找sentence起始點(含)
            if (i >= arr.length) break;
            start = i;
            while (i < arr.length && arr[i] != ' ') ++i; // 找sentence結束點(不含)
            end = i;
            reverse(arr, start, end);
        }
        return new String(arr);
    }
    public void reverse(char[] arr, int start, int end) {
        int i = start, j = end - 1;
        while (i < j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            ++i;
            --j;
        }
    }
}