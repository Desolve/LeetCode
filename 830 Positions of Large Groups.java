class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        if (S == null || S.length() < 0) return res;        
        int last = 0;
        char[] chs = S.toCharArray();
        for (int i = 1; i < chs.length; i++) {
            if (chs[i] != chs[last]) {
                if (i - last >= 3) {
                    List<Integer> grp = new ArrayList<>();
                    grp.add(last);
                    grp.add(i-1);
                    res.add(grp);
                }
                last = i;
            }
        }
        if (chs[chs.length - 1] == chs[last] && chs.length - last >= 3) {
            List<Integer> grp = new ArrayList<>();
            grp.add(last);
            grp.add(chs.length - 1);
            res.add(grp);
        }
        return res;
    }
}