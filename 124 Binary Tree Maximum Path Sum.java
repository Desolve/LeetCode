/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Don't need to check root at the very beginning since it's guaranteed non-empty.
class Solution {
    int res;
    public int maxPathSum(TreeNode root) {
        res = root.val;
        dfs(root);
        return res;
    }
    public int dfs(TreeNode root) {
        int m = root.val;
        int l = (root.left != null) ? dfs(root.left) : 0;
        int r = (root.right != null) ? dfs(root.right) : 0;
        m = Math.max(m, l + root.val);
        m = Math.max(m, r + root.val);
        res = Math.max(res, m);
        res = Math.max(res, l + r + root.val);
        return m;
    }
}