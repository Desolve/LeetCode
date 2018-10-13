/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* In-order Traversal */
class Solution {
    int minDiff = Integer.MAX_VALUE;
    TreeNode prev;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null) minDiff = Math.min(minDiff, root.val - prev.val);
        prev = root;
        inorder(root.right);       
    }
}
/* Using lower/upper bound to get each the minDiff
class Solution {
    long minDiff = Long.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return (int) minDiff;
    }
    public void helper(TreeNode root, long lb, long rb) {
        if (root == null) return;
        if (lb != Long.MIN_VALUE) minDiff = Math.min(minDiff, root.val - lb);
        if (rb != Long.MAX_VALUE) minDiff = Math.min(minDiff, rb - root.val);
        helper(root.left, lb, root.val);
        helper(root.right, root.val, rb);
    }
}
*/