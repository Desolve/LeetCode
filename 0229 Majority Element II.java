class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0)
            return res;
        int n1 = 0, n2 = 1, cnt1 = 0, cnt2 = 0;
        for (int num : nums) {
            if (num == n1) {
                ++cnt1;
            } else if (num == n2) {
                ++cnt2;
            } else if (cnt1 == 0) {
                n1 = num;
                cnt1 = 1;
            } else if (cnt2 == 0) {
                n2 = num;
                cnt2 = 1;
            } else {
                --cnt1;
                --cnt2;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        
        for (int num : nums) {
            if (num == n1) 
                ++cnt1;
            else if (num == n2)
                ++cnt2;
        }
        
        int len = nums.length;
        if (cnt1 > len / 3)
            res.add(n1);
        if (cnt2 > len / 3)
            res.add(n2);
        return res;
    }
}