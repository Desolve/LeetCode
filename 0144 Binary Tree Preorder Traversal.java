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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }
    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
}

/* Iterative solution using Stack
// root -> left -> right => In stack: push right->left->root (LIFO)
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        if (root != null) {
            st.push(root);
            while (!st.isEmpty()) {
                TreeNode n = st.pop();
                if (n.right != null) st.push(n.right);
                if (n.left != null) st.push(n.left);
                res.add(n.val);
            }
        }
        return res;
    }
}
*/