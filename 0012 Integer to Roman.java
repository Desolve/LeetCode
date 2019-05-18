class Solution {
    public String intToRoman(int num) {
        if (num <= 0) return "";
        String ret = "";
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] flags = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for(int i=0; i < 13 && num > 0; i++) {
            if (num < nums[i]) continue;
            while(num >= nums[i]) {
                num -= nums[i];
                ret += flags[i];
            }
        }
        return ret;
    }
}