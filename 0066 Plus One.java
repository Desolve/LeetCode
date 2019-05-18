class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        boolean iscarry = true;
        for(int digit: digits) {
            if(digit != 9) {
                iscarry = false;
                break;
            }
        }
        if(iscarry) {
            int [] result = new int[len+1];
            result[0] = 1;
            return result;
        } else {
            int carry = 1;
            for(int i = len-1; i >= 0; i--) {
                if(carry == 0) {
                    break;
                } else {
                    digits[i] += 1;
                    if(digits[i] == 10) {
                        digits[i] = 0;
                        carry = 1;
                    } else {
                        carry = 0;
                    }
                }
            }
            return digits;
        }
    }
}