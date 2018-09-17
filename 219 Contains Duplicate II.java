class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i-k-1]); // 將超過當前index距離k+1的自set中刪去
            if (!set.add(nums[i])) return true; // 如果set無法新增，表示存在距離k以內的相同num
        }
        return false;
    }
}

/* A much faster solution by ofLucas */

/*
public class Solution {
    public void xwap(int[] a, int i, int j) { 
        int tmp=a[i]; 
        a[i]=a[j]; 
        a[j]=tmp; 
    } 
     
    public void qsort(int[] a, int[] indice, int s, int t) { 
        if (s>=t) return; 
        int mid=a[(s+t)/2], i=s, j=t; 
        while (i<j) { 
            while (i<j && a[i]<mid) i++; 
            while (i<j && a[j]>mid) j--; 
            if (a[i]==mid && a[j]==mid) j--; 
            if (i<j) { 
                xwap(a,i,j); 
                xwap(indice,i,j); 
            } 
        } 
        qsort(a,indice,s,i-1); 
        qsort(a,indice,i+1,t); 
    } 

    public boolean containsNearbyDuplicate(int[] nums, int k) { 
        if (nums==null) return false; 
        if (nums.length<2) return false; 
        int n=nums.length; 
        int[] indice = new int[n]; 
        for (int i=0; i<n; i++) indice[i]=i; 
        qsort(nums,indice,0,n-1); // 用nums的值的大小來對nums和indice(表示原始對應的index)做排序

        for (int i=0; i<n; i++) {
            int j=i+1;
            while (j<n && nums[j]==nums[i]) { // 檢查兩者值是否相等
                if (Math.abs(indice[i]-indice[j])<=k) return true; // 檢查原始對應的index差的絕對值是否在k以內
                j++;
            }
        }
            
        return false; 
    }
}
*/