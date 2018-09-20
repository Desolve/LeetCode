class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        if (num == 1) return true; // 不用這行也能pass, 但實測效率比較好，可能測資有很多筆1?
        while((num & 1) == 0) num >>= 1;
        while(num % 3 == 0) num /= 3;
        while(num % 5 == 0) num /= 5;
        return (num == 1);
    }
}