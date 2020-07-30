class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        ArrayList<Integer> combo = new ArrayList<Integer>();
        if (n <= 0 || k <= 0) return res;
        findCombos(res, n, k, 1, combo);
        return res;
    }
    
    public void findCombos(List<List<Integer>> res, int n, int k, int i, ArrayList<Integer> combo) {
        if (k == 0) {
            res.add(new ArrayList<>(combo));
        } else if (i + k - 1 <= n) {
            combo.add(i);
            findCombos(res, n, k - 1, i + 1, combo);
            combo.remove(combo.size() - 1);
            findCombos(res, n, k, i + 1, combo);
        }
    }
}