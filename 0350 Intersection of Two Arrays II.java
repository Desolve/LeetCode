class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int num: nums1) map1.put(num, map1.getOrDefault(num, 0)+1);
        for (int num: nums2) {
            int cnt = map1.getOrDefault(num, 0);
            if (cnt > 0) {
                res.add(num);
                map1.put(num, --cnt);
            }
        }
        int[] in = new int[res.size()];
        for (int i = 0; i < res.size(); i++) 
            in[i] = res.get(i);
        return in;
    }
}