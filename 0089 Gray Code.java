class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        if (n == 0) return res;
        int adder = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = adder - 1; j >= 0; j--) {
                res.add(res.get(j) + adder);
            }
            adder *= 2;
        }
        return res;
    }
}