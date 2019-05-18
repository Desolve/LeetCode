class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<Integer>();
        Set<Integer> res = new HashSet<Integer>();
        for (int num: nums1) s1.add(num);
        for (int num: nums2) {
            if (s1.contains(num)) {
                res.add(num);
            }
        }
        int[] arr = new int[res.size()];
        int i = 0;
        for (int num: res) arr[i++] = num;
        return arr;
    }
}


/* Another solution:
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        //Add all elements to set from array 1
        for(int i =0; i< nums1.length; i++) set.add(nums1[i]);
        for(int j = 0; j < nums2.length; j++) {
           // If present in array 2 then add to res and remove from set 
           if(set.contains(nums2[j])) {
                res.add(nums2[j]);
                set.remove(nums2[j]);
            }
        }
        // Convert ArrayList to array
        int[] arr = new int[res.size()];
        for (int i= 0; i < res.size(); i++) arr[i] = res.get(i);
        return arr;
    }
}
*/