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
    public TreeNode increasingBST(TreeNode root) {
        return helper(root, null);
    }
    public TreeNode helper(TreeNode root, TreeNode tail) {
        if (root == null) return tail;
        TreeNode res = helper(root.left, root);
        root.left = null;
        root.right = helper(root.right, tail);
        return res;
    }
}

/* iterative version from zzhai

class Solution {
    public TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode dummy = new TreeNode(0), p = dummy;
        while (root != null || !stack.empty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode cur = stack.pop();
                root = cur.right;
                cur.left = null;
                p.right = cur;
                p = p.right;
            }
        }
        return dummy.right;
    }
}
*/