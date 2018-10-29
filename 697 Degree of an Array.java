class Solution {
    class Node {
        int start, end, cnt;
        Node() {
            start = -1;
            end = -1;
            cnt = 0;
        }
    }
    public int findShortestSubArray(int[] nums) {
        int max = 0;
        int mlen = 0;
        Node[] n = new Node[50000]; // nums[i] will be an integer between 0 and 49,999
        for (int i = 0; i < nums.length; ++i) {
            if (n[nums[i]] == null) n[nums[i]] = new Node(); // Only create instance when the number is used
            if (n[nums[i]].start == -1) n[nums[i]].start = i;
            n[nums[i]].end = i;
            n[nums[i]].cnt += 1;
            if (n[nums[i]].cnt > max) { // When the maximum frequency changes, minimum length should just align the new length
                max = n[nums[i]].cnt;
                mlen = n[nums[i]].end - n[nums[i]].start + 1;
            } else if (n[nums[i]].cnt == max) { // When the count is same as max, we need to compared the lengths
                mlen = Math.min(mlen, n[nums[i]].end - n[nums[i]].start + 1);
            }
        }
        return mlen;
    }
}

/* Similar solution using HashMap
class Solution {
    public int findShortestSubArray(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
           if (!map.containsKey(nums[i])){
               map.put(nums[i], new int[]{1, i, i});  // the first element in array is degree, second is first index of this key, third is last index of this key
           } else {
               int[] temp = map.get(nums[i]);
               temp[0]++;
               temp[2] = i;
           }
        }
        int degree = Integer.MIN_VALUE, res = Integer.MAX_VALUE;
        for (int[] value : map.values()){
            if (value[0] > degree){
                degree = value[0];
                res = value[2] - value[1] + 1;
            } else if (value[0] == degree){
                res = Math.min( value[2] - value[1] + 1, res);
            } 
        }
        return res;
    }
}
*/