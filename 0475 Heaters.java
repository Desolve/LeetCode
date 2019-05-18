// 1. 先將heaters排序
// 2. 最小的radius取決於每個house距離左右兩邊最近的heater有多近
// 3. 如果array中並不含search key, binarySearch會回傳(-(insertion point)+1)做為結果以表示insert進去會插入的位置。

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int res = Integer.MIN_VALUE;
        for (int house: houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) index = -(index + 1);
            int d1 = index - 1 >= 0? house - heaters[index - 1]: Integer.MAX_VALUE;
            int d2 = index < heaters.length? heaters[index]-house: Integer.MAX_VALUE;
            res = Math.max(res, Math.min(d1, d2));
        }
        return res;
    }
}