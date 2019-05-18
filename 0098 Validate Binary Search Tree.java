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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        boolean l = true;
        boolean r = true;
        if (root.left != null) l = isValidBST(root.left, min, root.val);
        if (root.right != null) r = isValidBST(root.right, root.val, max);
        return l && r;
    }
    public boolean isValidBST(TreeNode n, long min, long max) {
        if (!(n.val > min && n.val < max)) return false;
        if (n.left == null && n.right == null) return true;
        boolean l = true; boolean r = true;
        if (n.left != null) l = isValidBST(n.left, min, n.val);
        if (n.right != null) r = isValidBST(n.right, n.val, max);
        return l && r;
    }
}

/* Using post-order: storing the last value
class Solution {
    TreeNode last;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;        
        if (last != null && root.val <= last.val) return false;
        last = root;
        return isValidBST(root.right);
    }
}
// in-order
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.empty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }
            else {
                root = stack.pop();
                if (pre != null && pre.val >= root.val) {
                    return false;
                }
                pre = root;
                root = root.right;
            }
        }
        return true;
    }
}
*/