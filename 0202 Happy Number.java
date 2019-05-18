class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int next;
        while (!set.contains(n)) {
            if (n == 1) return true;
            set.add(n);
            next = 0;
            while (n != 0) {
                int remain = n % 10;
                n /= 10;                
                next += Math.pow(remain, 2);
            }
            n = next;
        }
        return false;
    }
}