class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int sum = 1, mid = (int) Math.sqrt(num);
        for (int i = 2; i <= mid; ++i) {
            if (num % i == 0)
                sum += i + num / i;
            if (sum > num) return false;
        }
        if (sum == num) return true;
        return false;
    }
}

/* Slightly faster solution:
class Solution {
    public boolean checkPerfectNumber(int num) {
        int sum = 1;
        for (int i=2;i<Math.sqrt(num);i++) 
            if (num % i == 0) sum += i + (num/i == i ? 0 : num/i);
        return num != 1 && sum == num;
    }
}
*/