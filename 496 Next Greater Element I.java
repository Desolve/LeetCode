class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for (int num : nums2) {
            while (!st.isEmpty() && st.peek() < num)
                map.put(st.pop(), num);
            st.push(num);
        }
        for (int i = 0; i < nums1.length; i++)
            nums1[i] = map.getOrDefault(nums1[i], -1);
        return nums1;
    }
}

/* Explanation:
每一次在找某個數的next greater element時，
要看的就是這個數以後的位置是否存在比這個數大的數字的第一項。

我們可以保存一個stack，每次將nums2的num放入，
迴圈檢查碰到peek比現在這個num還小的狀況，
就將其pop後put到map裡。所以最後我們可以拿到map的對應關係是(p,num)，
這個p的位置會在num的前面(因為比較早進入stack中)，
且num會是p以後的數字中第一個比p還要大的。

比如[9,8,7,3,2,1,6]，對6來說可以得到(1,6),(2,6),(3,6)的對應關係，
它們都找到了對應的next greater element，所以可以被pop掉。
於是留在stack裡的會自然呈現遞減的狀態，每次尋找時，
只要依序找出比num小的部分，pop後將對應加到map裡，
最後我們就可以得到一個所有nge的對應表，
再用getOrDefault(nums1[i], -1)進行輸出。
如果不需做後續處理的話，直接取代掉nums1即可，
否則就需要另外再開一個nums1.length長度的array.

*/

/* Another Solution: (速度在這邊較快，旦其實是O(n*m)，前面的solution才是O(n))
(比較快的原因是因為省了一個stack, 且nums1和nums2的長度都不會超過1000)
public int[] nextGreaterElement(int[] findNums, int[] nums) {
    Map<Integer, Integer> m = new HashMap<>();
    // go through each element in nums and set its location in HashMap
    for(int i =0;i<nums.length;++i)
        m.put(nums[i],i); //since every element is unique, there is no need (getOrDefault)
    
    //scan each element in the first array    
    for(int i=0;i<findNums.length;++i)
    {
        int minIndex =-1;  //initially, set the finding index to be -1
        int index = m.get(findNums[i]); //findout the corresponding index in the second (nums) array.
        while(++index < nums.length) 
        {
            if(nums[index]>findNums[i])
            {
                minIndex =index;
                break;
            }
        }
        if(minIndex ==-1) findNums[i] = -1;
        else findNums[i] = nums[minIndex];
    }
    return findNums;
}
*/

/* Nearly the best solution: 
類似第一個解法，但是從尾到頭可以省下stack的部分。
每次往後一個看它是否比自己小(nums2[i]比nums2[i+1])，
比自己小的話就直接從map裡面找下一個比較大的來比。
如果比自己大的話，毫無疑問它就是nge，直接put到map即可。
都找不到的狀況就是-1，直接跳出該輪迴圈。

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result=new int[nums1.length];
        if(nums2.length==0 || nums1.length==0 || nums2.length==1){
            Arrays.fill(result,-1);
            return result;
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=nums2.length-2;i>=0;i--){
            int temp=nums2[i+1];
            while(temp!=-1){
                if(nums2[i]>temp){
                    temp=map.getOrDefault(temp,-1);
                }
                else{
                    map.put(nums2[i],temp);
                    break;
                }
            }
        }        
        for(int i=0;i<nums1.length;i++){
            result[i]=map.getOrDefault(nums1[i],-1);
        }
        return result;
    }
}
*/