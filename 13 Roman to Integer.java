class Solution {
    public int romanToInt(String s) {
        int sum = 0, len = s.length();
        for(int i = 0; i < len; i++) {
            if(i+1 >= s.length() || getnum(s.charAt(i+1)) <= getnum(s.charAt(i)))
                sum += getnum(s.charAt(i));
            else
                sum -= getnum(s.charAt(i)); 
        }
        return sum;
    }
    public int getnum(char romanChar) {
        switch (romanChar) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}