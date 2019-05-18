class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>(A.length);
        int num = 0;
        for (int i : A) {
            num = ((num << 1) + i) % 5;
            res.add(num == 0);
        }
        return res;
    }
}