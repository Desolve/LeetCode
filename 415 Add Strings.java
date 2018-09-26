class Solution {
    public String addStrings(String num1, String num2) {
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        char[] tmp;
        if (arr1.length < arr2.length) {
            tmp = arr1;
            arr1 = arr2;
            arr2 = tmp;
        }
        int carry = 0, sum = 0;
        for (int i = arr2.length - 1, j = arr1.length - 1; i >= 0; i--, j--) {
            sum = (arr2[i] - '0') + (arr1[j] - '0') + carry;
            carry = sum / 10;
            arr1[j] = (char)(sum % 10 + '0');
        }
        if (carry == 0) return new String(arr1);
        if (arr1.length == arr2.length) return ("1" + new String(arr1));
        for (int k = arr1.length-1-arr2.length; k >= 0 && carry == 1; k--) {
            if (arr1[k] == '9') {
                arr1[k] = '0';
                carry = 1;
            } else {
                arr1[k] += 1;
                carry = 0;
            }
        }
        if (carry == 0) return new String(arr1);
        return ("1" + new String(arr1));
    }
}