class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        if (target < candidates[0]) return res;
        List<Integer> combo = new ArrayList<>();
        findCombo(res, candidates, target, (ArrayList) combo, 0);
        return res;
    }
    public void findCombo(List<List<Integer>> res, int[] candidates, int remain, ArrayList<Integer> combo, int start) {
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remain) break;
            if (i > start && candidates[i] == candidates[i-1]) continue; // Prevent duplications
            else {
                combo.add(candidates[i]);
                if (candidates[i] == remain) {
                    res.add((ArrayList) combo.clone());
                    combo.remove(combo.size() - 1);
                    break;
                } else {
                    findCombo(res, candidates, remain - candidates[i], combo, i + 1);
                    combo.remove(combo.size() - 1);
                }
            }
        }
    }
    
}
