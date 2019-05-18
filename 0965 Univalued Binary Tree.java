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
    int val;
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        val = root.val;
        return unival(root);
    }
    public boolean unival(TreeNode n) {
        if (n == null) return true;
        if (n.val != val) return false;
        return unival(n.left) && unival(n.right);
    }
}

/* A clearer solution from jay27454788
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val != root.val) {
            return false;
        }
        if (root.right != null && root.right.val != root.val) {
            return false;
        }
        boolean rl = isUnivalTree(root.left);
        boolean rr = isUnivalTree(root.right);
        return (rl && rr);
    }
}
*/