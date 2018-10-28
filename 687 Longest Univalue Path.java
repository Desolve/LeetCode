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
    int mx = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        count(root, root.val);
        return mx;
    }
    public int count(TreeNode root, int val) {
        if (root == null) return 0;
        int l = count(root.left, root.val);
        int r = count(root.right, root.val);
        mx = Math.max(mx, l + r);
        if (val == root.val) return Math.max(l, r) + 1;
        return 0;
    }
}