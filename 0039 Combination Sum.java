class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        if (candidates.length == 0 || candidates[0] > target) return res;
        for (int i = 0; i < candidates.length; i++) {            
            List<Integer> combo = new ArrayList<>();
            if (candidates[i] <= target) {
                combo.add(candidates[i]);
                findCombo(res, candidates, target - candidates[i], (ArrayList) combo, i);
                combo.remove(combo.size() - 1);
            }
        }
        return res;
    }
    public void findCombo(List<List<Integer>> res, int[] candidates, int remain, ArrayList<Integer> combo, int start) {
        if (remain == 0) {
            res.add((ArrayList) combo.clone());
        } else {
            for (int i = start; i < candidates.length; ++i) {
                if (candidates[i] <= remain) {
                    combo.add(candidates[i]);
                    findCombo(res, candidates, remain - candidates[i], combo, i);
                    combo.remove(combo.size() - 1);
                } else {
                    return;
                }
            }
        }
    }
}