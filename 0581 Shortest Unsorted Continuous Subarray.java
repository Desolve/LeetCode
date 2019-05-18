class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length <= 1) return 0;
        int [] nnums = nums.clone();
        Arrays.sort(nnums);
        int start = nums.length, end = 0;
        for(int i = 0; i < nums.length; ++i) {
            if (nnums[i] != nums[i]) {
                start = i;
                break;
            }
        }
        for(int j = nums.length - 1; j >= 0; --j) {
            if (nnums[j] != nums[j]) {
                end = j;
                break;
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }
}
/* 
// beg: subarray的頭， end: subarray的尾，如果都沒變動的話，end-beg+1剛好等於預設値0
// 從頭到尾去算當下的max値， 若i的値比max小則將end的位置設到i上(因小於最大値，代表i在必須要sorting的範圍內)
// 從尾到頭去算當下的min値， 若n-1-i的値比min大則將beg的位置設到n-1-i上(因大於最小値，代表n-1-i在必須要sorting的範圍內)

public int findUnsortedSubarray(int[] A) {
    int n = A.length, beg = -1, end = -2, min = A[n-1], max = A[0];
    for (int i=1;i<n;i++) {
      max = Math.max(max, A[i]);
      min = Math.min(min, A[n-1-i]);
      if (A[i] < max) end = i;
      if (A[n-1-i] > min) beg = n-1-i; 
    }
    return end - beg + 1;
}
*/