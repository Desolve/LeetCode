class Solution {
    public int numberOfSteps (int num) {
        return Integer.bitCount(num) + Integer.toBinaryString(num).length() - 1;
    }
}

/* from leetcode
class Solution {
    public int numberOfSteps (int num) {
        int steps = 0;        
        while (num > 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }            
            steps++;
        }        
        return steps;
    }
}
*/