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
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        if (root.left == null && root.right == null) return root.val;
        if (root.left != null) helper(root.left, root.val * 2);
        if (root.right != null) helper(root.right, root.val * 2);
        
        return sum;
    }
    public void helper(TreeNode r, int val) {
        int tmp = val + r.val;
        if (r.left == null && r.right == null) sum += tmp;
        else {
            if (r.left != null) helper(r.left, tmp * 2);
            if (r.right != null) helper(r.right, tmp * 2);
        }
    }
}

// without using global value solution from lee215
/*
public int sumRootToLeaf(TreeNode root) {
    return dfs(root, 0);
}

public int dfs(TreeNode root, int val) {
    if (root == null) return 0;
    val = val * 2 + root.val;
    return root.left == root.right ? val : dfs(root.left, val) + dfs(root.right, val);
}
*/

