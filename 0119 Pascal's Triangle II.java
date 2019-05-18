class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new LinkedList<Integer>();
        for(int row = 0; row <= rowIndex; row++) {
            ans.add(0, 1);
            for(int i = 1; i < row; i++) {
                ans.set(i, ans.get(i) + ans.get(i+1));
            }
        }
        return ans;
    }
}