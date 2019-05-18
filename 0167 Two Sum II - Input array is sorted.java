class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i, j, diff;
        for (i = 0; i < numbers.length; i++) {
            diff = target - numbers[i];
            j = binarySearch(numbers, diff, i);
            if (j != -1)
                return new int[]{i+1, j+1};
        }
        return new int[]{ -1, -1 };
    }
    public int binarySearch(int[] numbers, int diff, int i) {
        int lo = 0;
        int hi = numbers.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (numbers[mid] == diff && mid != i) return mid;
            else if (numbers[mid] > diff) hi = mid-1;
            else lo = mid+1;            
        }
        return -1;
    }
}

/* Another better solution from discuss area: 
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[2];
        }
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                return new int[]{start + 1, end + 1};
            } else if (numbers[start] + numbers[end] > target) {
                // move end forward to the last value that numbers[end] <= target - numbers[start]
                end = largestSmallerOrLastEqual(numbers, start, end, target - numbers[start]);
            } else {
                // move start backword to the first value that numbers[start] >= target - numbers[end]
                start = smallestLargerOrFirstEqual(numbers, start, end, target - numbers[end]);
            }
        }
        return new int[]{start+1, end+1};
    }
    private int largestSmallerOrLastEqual(int[] numbers, int start, int end, int target) {
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
    private int smallestLargerOrFirstEqual(int[] numbers, int start, int end, int target) {
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}*/