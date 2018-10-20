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
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        preorder(t, sb);
        return sb.toString();
    }
    public void preorder(TreeNode t, StringBuilder sb) {
        if (t == null) return;
        sb.append(t.val);
        if (t.left == null && t.right == null) return;        
        if (t.left == null) {
            sb.append("()(");
            preorder(t.right, sb);
            sb.append(")");
        } else {
            sb.append("(");
            preorder(t.left, sb);
            sb.append(")");
            if (t.right != null) {            
                sb.append("(");
                preorder(t.right, sb);
                sb.append(")");  
            }
        }
    }
}

/* The above solutoin is simplified from the following solution, both written by myself,
this one should be easier to understand but slower.
class Solution {
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        preorder(t, sb);
        return sb.toString();
    }
    public void preorder(TreeNode t, StringBuilder sb) {
        if (t == null) return;
        sb.append(t.val);
        if (t.left == null && t.right == null) return;        
        if (t.left == null) {
            sb.append("()(");
            preorder(t.right, sb);
            sb.append(")");
            return;
        }
        if (t.right == null) {
            sb.append("(");
            preorder(t.left, sb);
            sb.append(")");
            return;
        }
        sb.append("(");
        preorder(t.left, sb);
        sb.append(")(");
        preorder(t.right, sb);
        sb.append(")");        
    }
}
*/