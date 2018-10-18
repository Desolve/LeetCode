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
    public int findTilt(TreeNode root) {
        int[] res = new int[1];
        helper(root, res);
        return res[0];
    }    
    public int helper(TreeNode root, int[] res) {
        if (root == null) return 0;
        int lsum = helper(root.left, res);
        int rsum = helper(root.right, res);
        res[0] += Math.abs(lsum - rsum);
        return lsum + rsum + root.val;
    }
}