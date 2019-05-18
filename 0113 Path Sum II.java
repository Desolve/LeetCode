/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        helper(root, path, res, root.val, sum);
        return res;
    }
    public void helper(TreeNode root, List<Integer> path, List<List<Integer>> res, int curr, int sum) {
        if (curr == sum && root.left == null && root.right == null) {
            res.add(new ArrayList<Integer>(path)); 
            return;
        }
        if (root.left != null) {
            path.add(root.left.val);
            helper(root.left, path, res, curr + root.left.val, sum);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.right.val);
            helper(root.right, path, res, curr + root.right.val, sum);
            path.remove(path.size() - 1);
        }            
    }
}