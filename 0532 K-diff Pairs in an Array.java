class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        int pair = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num: nums)
            map.put(num, map.getOrDefault(num, 0)+1);
        if (k == 0) {
            for(int key: map.keySet()) {
                if (map.get(key) >= 2) ++pair;
            }
        } else {
            for(int key: map.keySet()) {
                if (map.containsKey(key+k)) ++pair;
            }
        }        
        return pair;
    }
}