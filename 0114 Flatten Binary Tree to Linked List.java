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
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> st = new Stack<>();
        pushStack(st, root);
        st.pop();
        while(!st.isEmpty()) {
            root.left = null;
            root.right = st.pop();
            root = root.right;
        }
    }
    public void pushStack(Stack<TreeNode> st, TreeNode curr) {
        if (curr == null) return;
        pushStack(st, curr.right);
        pushStack(st, curr.left);
        st.push(curr);
    }
}
/* faster solution
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode l = root.left;
        TreeNode r = root.right;
        flatten(root.left);
        flatten(root.right);
        
        root.left = null;
        root.right = l;
        
        while (root.right != null) 
            root = root.right;  
        
        root.right = r;
        
    }
}
*/
/*
class Solution {
    public void flatten(TreeNode root) {
        if (root != null) {
            helper(root);
        }
    }
    public TreeNode helper(TreeNode curr) {
        if (curr.left == null && curr.right == null) return curr;
        TreeNode l = curr.left;
        TreeNode r = curr.right;
        
        TreeNode next = (l == null) ? r : l;
        TreeNode lEnd = (l == null) ? curr : helper(l);
        TreeNode rEnd = (r == null) ? lEnd : helper(r);
        lEnd.right = r;
        curr.left = null;
        curr.right = next;
        return rEnd;
    }
}
*/