// We could use the reverse function of Problem 7.
// If x < 0 of course it's NOT palindrome.
// Otherwise, use reverse function to get reversed value and check if rev == x;
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) 
            return false;
        int rev = reverse(x);
        if (x == rev)
            return true;
        return false;
    }
    public int reverse(int x) {
        int rev = 0;
		while(x != 0) {
			int pop = x % 10;
            x /= 10;
			if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && pop > 7)) return 0;
			if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && pop < -8)) return 0;
			rev = rev * 10 + pop;
		}
		return rev;
    }
}


/* Another solution is to transform to string and check char by char.
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) 
            return false;
        return checkReverse(x);
    }
    public boolean checkReverse(int x) {
        String str = String.valueOf(x);
        int len = str.length();
        for(int i = 0, j = len-1; i < j; i++, j--) {
            if(str.charAt(i) != str.charAt(j)) return false;
        }
        return true;
    }
}
*/