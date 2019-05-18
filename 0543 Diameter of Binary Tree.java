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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {        
        depth(root);
        return max;
    }
    public int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}

/* Without class variable: using one integer array to make input editable. (slower)
public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];        
    }

    private int height(TreeNode node, int[] diameter) {
        if (node == null) {
            return 0;
        }
        int lh = height(node.left, diameter);
        int rh = height(node.right, diameter);
        diameter[0] = Math.max(diameter[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }
}
*/