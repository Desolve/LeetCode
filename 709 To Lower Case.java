// String.valueOf(arr)也可，但會比String(arr)慢一點
class Solution {
    public String toLowerCase(String str) {
        char[] arr = str.toCharArray();
        for(int i = 0; i < arr.length; ++i) {
            if (arr[i] >= 'A' && arr[i] <= 'Z') {
                arr[i] += 32;
            }
        }
        return new String(arr);
    }
}