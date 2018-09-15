class Solution {
    public int countPrimes(int n) {
        if (n == 0 || n == 1 || n == 2) return 0;
        if (n == 3) return 1;
        boolean[] nPrime = new boolean[n];
        int sum = 0;
        for (int i = 2; i < n; i++) {
            if(!nPrime[i]) {
                for (int j = i * 2; j < n; j+=i)
                    nPrime[j] = true;
                sum++;
            }
        }
        return sum;
    }
}