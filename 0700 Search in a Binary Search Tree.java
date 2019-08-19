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
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (val == root.val) return root;
            if (val > root.val) root = root.right;
            else root = root.left;
        }
        return null;
    }
}

/* Recursive solution
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || val == root.val)
            return root;
        return val < root.val? searchBST(root.left,val): searchBST(root.right,val);
    }
}
*/