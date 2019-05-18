// pop = x % 10; => no way to overflow
// x /= 10; => no way to overflow
// temp = rev * 10 + pop; 
// if rev > 0 => rev >= INTMAX/10 is guaranteed to overflow
// if rev > INTMAX/10, then temp = rev*10 + pop is guaranteed to overflow
// if rev == INTMAX/10, then temp = rev*10 + pop
// Since INTMAX = 2^31-1 is 2147483647, temp would overflow if and only if pop > 7.
// INTMIN = -2^31 is -2147483648, rev < INTMIN/10 = -214748364 is guaranteed to overflow
// if rev == INTMIN/10, temp = -214748364 + pop, temp would overflow if pop < -8
// Since then, logic can be applied.

class Solution {
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