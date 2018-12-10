class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();        
        for (int i = 0; i < nums.length - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            List<List<Integer>> tmp = new ArrayList<>();
            threeSum(tmp, i, nums, target - nums[i]);
            for (List l : tmp) {
                res.add(l);
            }            
        }
        return res;
    }
    public void threeSum(List<List<Integer>> r, int start, int[] nums, int target) {
        for (int i = start + 1; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1, t = target - nums[i];
            if (i > start + 1 && nums[i] == nums[i - 1]) continue;
            while (j < k) {
                if (nums[j] + nums[k] == t) {
                    r.add(Arrays.asList(nums[start], nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    ++j; --k;
                } else if (nums[j] + nums[k] < t) ++j;
                else --k;
            }
        }
    }
}

/* Easy, clear and faster solution from iChuan
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //fix two numbers, two pointer to other two numbers.
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) { //our pointer(based on first number) is larger(pass) than target, stop searching.
                break;
            }
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target) {
                continue; //first candidate is too small.
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // this value is already visited, skip to avoid duplicated value.
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break; // our pointer based on second number is passed the target, stop searching.
                }
                if (nums[i] + nums[j] + nums[nums.length - 1] + nums[nums.length - 2] < target) { //j is too small
                    continue;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) { //here should be j > i + 1, because j can be equal to i at j = i + 1
                    continue;  // this value is already visited, skip to avoid duplicated value.
                }
                //Two pointer.
                int start = j + 1;
                int end = nums.length - 1;
                
                while (start < end) {
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        
                        while (start < end && nums[start] == nums[start + 1]) {
                            start++; // skip duplicated value.
                        }
                        while (start < end && nums[end] == nums[end - 1]) {
                            end--;
                        }
                        start++;
                        end--;
                    } else if (sum < target) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return result;
    }
}
*/