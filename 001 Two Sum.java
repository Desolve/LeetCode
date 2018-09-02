class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[] { map.get(complement), i};
            }
            map.put(nums[i], i); // Add the (key, value) pair in this loop
            /* Notice that we may NOT get the answer at the first time
               since the related pair could haven't been inserted yet.
               But we are sure that when the second time
               we met one of the answer nums, the first one is already inside
               so that we could return the int[] to get the answers. */               
        }
        throw new IllegalArgumentException("No Answer");
    }
}