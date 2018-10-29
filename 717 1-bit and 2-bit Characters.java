class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        boolean isOne = false;
        for (int i = 0; i < bits.length; ++i) {
            if (bits[i] == 1) {
                ++i;
                isOne = false;
            } else {
                isOne = true;
            }
        }
        return isOne;
    }
}

/* Slightly faster solution
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length, i = 0;
        while (i < n - 1) {
            if (bits[i] == 0) i++;
            else i += 2;
        }
        return i == n - 1;
    }
}
*/