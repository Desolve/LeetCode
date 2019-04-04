class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        if (time.length < 2) return 0;
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            int val = time[i] % 60;
            cnt += map.getOrDefault(60 - val, 0);
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        if (map.containsKey(0)) {
            int val = map.get(0);
            return cnt + (val - 1) * val / 2;
        }
        return cnt;
    }
}

/* Solution from hxc0re
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] m = new int[60];
        int ret = 0;
        
        for (int i = time.length - 1; i >= 0; i--){
            ret+=m[(60 - time[i]%60)%60];
            m[time[i]%60]++;
        }
        return ret;
    }
}
*/