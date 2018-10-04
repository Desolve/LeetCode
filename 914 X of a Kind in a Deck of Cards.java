// 20 ms solution
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        int common = 0;
        for (int i : deck) 
            cnt.put(i, cnt.getOrDefault(i, 0)+1);
        for (int i : cnt.values()) {
            common = gcd(i, common);
            if (common <= 1) return false;
        }
        if (common > 1)
            return true;
        return false;
    }
    public int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b): a;
    }
}

// 8 ms solution using array
/*
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] cnt = new int[10000]; // Since 0 <= deck[i] < 10000 
        int common = 0;
        for (int i : deck) cnt[i]++;        
        for (int i : cnt) {
            if (i == 0) continue;
            common = gcd(i, common);
            if (common <= 1) return false;
        }
        if (common > 1)
            return true;
        return false;
    }
    public int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b): a;
    }
}
*/