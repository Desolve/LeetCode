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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return sumOfLeftLeaves(root.left, 1) + sumOfLeftLeaves(root.right, -1); // 1: root->left, -1: root->right        
    }
    public int sumOfLeftLeaves(TreeNode root, int from) {
        if (root == null) return 0;
        if (from == 1 && root.left == null && root.right == null) return root.val;
        return sumOfLeftLeaves(root.left, 1) + sumOfLeftLeaves(root.right, -1);
    }
}