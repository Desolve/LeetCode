class Solution {
    public int myAtoi(String str) {
        int res = 0, sign = 1;
        boolean first = true;
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == ' ' && first) continue;
            if (str.charAt(i) == '-' && first) {
                first = false;
                sign = -1;
                continue;
            }
            if (str.charAt(i) == '+' && first) {
                first = false;
                sign = 1;
                continue;
            }
            if (str.charAt(i) < 48 || str.charAt(i) > 57) break;
            if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                first = false;
                if((res*sign)>Integer.MAX_VALUE/10 || ((res*sign)==Integer.MAX_VALUE/10 && Integer.valueOf(String.valueOf(str.charAt(i)))>7)) 
	                    return Integer.MAX_VALUE;
	                if((res*sign)<Integer.MIN_VALUE/10 || ((res*sign)==Integer.MIN_VALUE/10 && Integer.valueOf(String.valueOf(str.charAt(i)))>8)) 
	                    return Integer.MIN_VALUE;
	                
	                res = res*10 + Integer.valueOf(String.valueOf(str.charAt(i)));
            }
        }
        return res * sign;
    }
}

/* faster solution from jeffzhou111
class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if(str.length() == 0 || (!Character.isDigit(str.charAt(0)) && str.charAt(0)!= '-' && str.charAt(0)!= '+')) return 0;
        long num = 0;
        if(Character.isDigit(str.charAt(0))) num = str.charAt(0) - '0';
        int count = 0;
        for(int i = 1; i < str.length() && Character.isDigit(str.charAt(i)); i++) {
            if(count > 12) break;
            num = num * 10 + str.charAt(i) - '0';
            if(num != 0)count++;
        }
        if(str.charAt(0)!= '-') return num > (long)Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)num;
        else return -num < (long)Integer.MIN_VALUE ? Integer.MIN_VALUE : (int)(-num);
    }
}
*/