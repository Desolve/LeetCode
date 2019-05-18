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
    public boolean res = true;
    public boolean isBalanced(TreeNode root) {
        maxdp(root);
        return res;
    }
    public int maxdp(TreeNode root) {
        if(root == null)
            return 0;
        int l = maxdp(root.left);
        int r = maxdp(root.right);
        if (l == -1 || r == -1 || Math.abs(l - r) > 1) {
            res = false;
            return -1;
        }
        return 1 + Math.max(l, r);
    }
}