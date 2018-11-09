class Solution {
    public int countPrimeSetBits(int L, int R) {
        Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));
        int cnt = 0;
        for (int i = L; i <= R; i++) {
            int bits = 0;
            bits = Integer.bitCount(i);
            if (primes.contains(bits))
                ++cnt;
        }
        return cnt; 
    }


/* Since the primes' range is small (2 to 19), using normal check prime would be better.
class Solution {
    public int countPrimeSetBits(int L, int R) {

        int count = 0;
        for (int i = L; i <= R; i++) {
            int ones = Integer.bitCount(i); //get the number of ones 
            if (isPrime(ones)) //check if the num is prime
                count++;

        }
        return count;
    }

    private boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
*/