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
    int num;
    public boolean isCompleteTree(TreeNode root) {
        num = count(root);
        return isComplete(root, 0);
    }
    private int count(TreeNode n) {
        if (n == null) return 0;
        else return 1 + count(n.left) + count(n.right);
    }
    private boolean isComplete(TreeNode n, int index) {
        if (n == null) return true;
        if (index >= num) return false;
        return isComplete(n.left, index * 2 + 1) && isComplete(n.right, index * 2 + 2); 
    }
}

/* Iterative solution : meeting first null means the remaining must be null
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        boolean end = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n == null) end = true;
            else {
                if (end) return false;
                q.add(n.left);
                q.add(n.right);
            }
        }
        return true;
    }
}
*/