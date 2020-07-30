class Solution {
    public int findNumbers(int[] nums) {
        int cnt = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                ++cnt;
            }
        }
        return cnt;
    }
}

/* solution using dividing by 10
class Solution {
    public int findNumbers(int[] nums) {
        int cnt = 0;
        for (int num : nums) {
            boolean isEven = true;
            while (num > 0) {
                num /= 10;
                isEven = !isEven;
            }
            if (isEven) {
                ++cnt;
            }
        }
        return cnt;
    }
}
*/