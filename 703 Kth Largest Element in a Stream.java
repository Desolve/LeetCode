class KthLargest {
    ArrayList<Integer> arr;
    int k;
    public KthLargest(int k, int[] nums) {
        Arrays.sort(nums);
        arr = new ArrayList<Integer>();
        for (int i : nums) arr.add(i);
        this.k = k;
    }
    
    public int add(int val) {
        int index = Collections.binarySearch(arr, val);
        if (index >= 0) arr.add(index, val);
        else arr.add(-index - 1, val);
        return arr.get(arr.size() - k);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

/* minHeap using PriorityQueue
class KthLargest {

    PriorityQueue<Integer> minHeap; 
    int k;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;
        for(int val: nums) {
            if(minHeap.size()<k||val>minHeap.peek()) minHeap.add(val);
            if(minHeap.size()>k) minHeap.poll();
        }
    }

    public int add(int val) {
        if(minHeap.size()<k||val>minHeap.peek()) minHeap.add(val);
        if(minHeap.size()>k) minHeap.poll();
        return minHeap.peek();
    }
    
}
*/